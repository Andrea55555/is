package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelBook {
    private Map<Integer, String> telBook;

    public TelBook(final Map<Integer, String> telBook) {
        this.telBook = telBook;
    }

    private void fillMap() throws Exception1, FileNotFoundException {
        File file = new File("iscl.txt");
        Scanner reader = new Scanner(new FileReader(file));
        Scanner writer = new Scanner(System.in);
        while (reader.hasNextLine()) {
            String[] columns = reader.nextLine().split("-");
            telBook.put(Integer.parseInt(columns[0]), columns[1]);
        }

        boolean isAll = false;
        while (!isAll) {
            System.out.println("номер телефона");
            Integer phone = writer.nextInt();
            System.out.println("имя");
            String name = writer.next();
            if (telBook.containsKey(phone)) {
                throw new Exception1("Такой телефон уже есть");
            } else {
                telBook.put(phone, name);
            }
            System.out.println("Добавить еще один контакт? Any text-restart/no");
            String condition = writer.next();
            if (condition.equals("no")) {
                isAll = true;
            }
        }
    }

    public void writeToFile(final Map<Integer, String> map) {
        try {
            File ourFile = new File("iscl.txt");
            FileOutputStream fos = new FileOutputStream(ourFile, false);
            PrintWriter pw = new PrintWriter(fos);
            for (Map.Entry<Integer, String> m : map.entrySet()) {
                pw.println(m.getKey() + "-" + m.getValue());
            }
            pw.flush();
            pw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> newTelBook = new HashMap<>();
        TelBook myContacts = new TelBook(newTelBook);
        System.out.println("Добавьте запись");
        try {
            myContacts.fillMap();
        } catch (Exception1 e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            myContacts.writeToFile(myContacts.telBook);
        }

    }
}