package org.example;

import org.example.controller.*;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();
        HumanCreator humanCreator = new HumanCreator();


        List<Human> humans = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);


        System.out.println("Введіть кількість факультетів: ");
        int facultyCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < facultyCount; i++) {
            System.out.println("Введіть назву факультету " + (i + 1) + ": ");
            String facultyName = scanner.nextLine();

            System.out.println("Введіть дані голови факультету " + facultyName + ":");
            System.out.println("Ім'я: ");
            String headFirstName = scanner.nextLine();
            System.out.println("Прізвище: ");
            String headLastName = scanner.nextLine();
            System.out.println("По-батькові: ");
            String headPatronymic = scanner.nextLine();
            System.out.println("Стать (MALE або FEMALE): ");
            String headSexStr = scanner.nextLine();
            Sex headSex = Sex.valueOf(headSexStr.toUpperCase());
            Human head = humanCreator.createHuman(headFirstName, headLastName, headPatronymic, headSex);


            Faculty faculty = facultyCreator.createFaculty(facultyName, head, departments);
            faculties.add(faculty);


            System.out.println("Введіть кількість кафедр на факультеті " + facultyName + ": ");
            int departmentCount = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < departmentCount; j++) {
                System.out.println("Введіть назву кафедри " + (j + 1) + " на факультеті " + facultyName + ": ");
                String departmentName = scanner.nextLine();
                Department department = departmentCreator.createDepartment(departmentName, groups);
                departments.add(department);


                System.out.println("Введіть кількість груп на кафедрі " + departmentName + ": ");
                int groupCount = scanner.nextInt();
                scanner.nextLine();
                for (int k = 0; k < groupCount; k++) {
                    System.out.println("Введіть назву групи " + (k + 1) + " на кафедрі " + departmentName + ": ");
                    String groupName = scanner.nextLine();
                    Group group = groupCreator.createGroup(groupName, students);
                    groups.add(group);


                    System.out.println("Введіть кількість студентів в групі " + groupName + ": ");
                    int studentCount = scanner.nextInt();
                    scanner.nextLine();
                    for (int l = 0; l < studentCount; l++) {
                        System.out.println("Введіть дані для студента " + (l + 1) + " в групі " + groupName + ":");
                        System.out.println("Ім'я: ");
                        String studentFirstName = scanner.nextLine();
                        System.out.println("Прізвище: ");
                        String studentLastName = scanner.nextLine();
                        System.out.println("По-батькові: ");
                        String studentPatronymic = scanner.nextLine();
                        System.out.println("Стать (MALE або FEMALE): ");
                        String studentSexStr = scanner.nextLine();
                        Sex studentSex = Sex.valueOf(studentSexStr.toUpperCase());
                        Student student = studentCreator.createStudent(studentFirstName, studentLastName, studentPatronymic, studentSex, group);
                        students.add(student);
                    }
                }
            }
        }
    }
}