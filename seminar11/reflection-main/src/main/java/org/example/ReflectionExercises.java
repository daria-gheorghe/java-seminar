package org.example;

import java.lang.reflect.*;

public class ReflectionExercises
{
    public static void main(String[] args)
    {
        try
        {
            Class<?> clazz = Student.class;

            System.out.println("=== CLASS INFORMATION ===");
            System.out.println("Class Name: " + clazz.getName());
            System.out.println("Package Name: " + clazz.getPackage().getName());
            System.out.println("Superclass: " + clazz.getSuperclass().getName());
            System.out.println("Interfaces:");

            Class<?>[] interfaces = clazz.getInterfaces();

            for(Class<?> i : interfaces)
            {
                System.out.println(i.getName());
            }


            System.out.println("\n=== FIELDS ===");

            Field[] fields = clazz.getDeclaredFields();

            for(Field field : fields)
            {
                System.out.println(
                        "Name: " + field.getName() + ", Type: " + field.getType().getSimpleName() + ", Modifiers: " + Modifier.toString(field.getModifiers()));
            }


            System.out.println("\n=== METHODS ===");

            Method[] methods = clazz.getDeclaredMethods();

            for(Method method : methods)
            {
                System.out.println(
                        "Name: " + method.getName() + ", Return Type: " + method.getReturnType().getSimpleName() + ", Modifiers: " + Modifier.toString(method.getModifiers()));
            }



            System.out.println("\n=== DYNAMIC OBJECT CREATION ===");
            Object obj = clazz.getDeclaredConstructor().newInstance();
            System.out.println("Object created: " + obj.getClass().getSimpleName());



            System.out.println("\n=== INVOKE METHOD ===");
            Method sayHelloMethod = clazz.getMethod("sayHello");
            sayHelloMethod.invoke(obj);


            System.out.println("\n=== ACCESS PRIVATE FIELD ===");
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            System.out.println("Old value: " + nameField.get(obj));
            nameField.set(obj, "Daria");
            System.out.println("New value: " + nameField.get(obj));


            System.out.println("\n=== INVOKE PRIVATE METHOD ===");
            Method privateMethod = clazz.getDeclaredMethod("secretMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(obj);


            System.out.println("\n=== CONSTRUCTOR SELECTION ===");
            Constructor<?> c1 = clazz.getConstructor();
            Object s1 = c1.newInstance();
            System.out.println("Student 1 created");


            Constructor<?> c2 = clazz.getConstructor(String.class);
            Object s2 = c2.newInstance("Alex");
            System.out.println("Student 2 created");

            Constructor<?> c3 = clazz.getConstructor(String.class, int.class);
            Object s3 = c3.newInstance("Maria", 22);
            System.out.println("Student 3 created");

            System.out.println("\n=== OBJECT INSPECTOR ===");
            inspect(s1);
            inspect(s2);
            inspect(s3);

            System.out.println("\n=== JSON SERIALIZER ===");
            String json = toJson(s3);
            System.out.println(json);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void inspect(Object obj)
    {
        Class<?> clazz = obj.getClass();
        System.out.println("\nInspecting: " + clazz.getSimpleName());
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields)
        {
            try
            {   field.setAccessible(true);
                System.out.println(field.getName() + " = " + field.get(obj));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static String toJson(Object obj)
    {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder json = new StringBuilder();
        json.append("{");
        for(int i = 0; i < fields.length; i++)
        {
            try
            {   fields[i].setAccessible(true);
                String fieldName = fields[i].getName();
                Object value = fields[i].get(obj);
                json.append("\"").append(fieldName).append("\":");

                if(value instanceof String)
                {
                    json.append("\"").append(value).append("\"");
                }
                else
                {
                    json.append(value);
                }

                if(i < fields.length - 1)
                {
                    json.append(",");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}