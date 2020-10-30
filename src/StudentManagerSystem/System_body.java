package StudentManagerSystem;


import StudentManagerSystem.DAO.ManagerDAO1;
import StudentManagerSystem.DAO.ManagerDAO1;
import StudentManagerSystem.DAO.StudentDAO;
import StudentManagerSystem.vo.Manager;
import StudentManagerSystem.vo.Student;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class System_body {
    Scanner sca = new Scanner(System.in);
    public static List<Student> stu = StudentDAO.findAll();
    public static List<Manager> man = ManagerDAO1.findAll();

    /**
     * 主页面
     */
    public void menu() {
        System.out.println("***************欢迎来到学生管理系统***************");
        System.out.println("请选择登录身份:\n1.管理员的登录\n2.学生登录\n3.退出");
        while (true) {
            int a = sca.nextInt();
            switch (a) {
                case 1 -> {
                    System.out.println("*****************欢迎来到管理端*****************");
                    ManagerLogin();
                }
                case 2 -> smenu();
                case 3 -> System.exit(0);
                default -> System.out.println("请输入正确指令:");
            }
        }

    }

    /**
     * 学生欢迎界面（注册/登录）
     */
    private void smenu() {
        System.out.println("*****************欢迎来到学生端*****************");
        System.out.println("请选择您要使用功能:\n1.注册\n2.登录\n3.退出");
        while (true) {
            int a = sca.nextInt();
            switch (a) {
                case 1 -> studentRegister();
                case 2 -> StudentLogin();
                case 3 -> System.exit(0);
                default -> System.out.println("请输入正确命令:");
            }
        }
    }

    /**
     * 学生注册
     */
    private void studentRegister() {
        System.out.println("请输入您要注册的学号:");
        int sid = sca.nextInt();
        for (Student student : stu) {
            if (student.getSid() == sid) {
                System.out.println("该学号已存在，请重新输入!!!");
                studentRegister();
            }
        }

        System.out.println("请输入您的姓名:");
        String sname = sca.next();
        System.out.println("请输入您的性别:");
        String sex;
        while (true) {
            sex = sca.next();
            if (sex.equals("男") || sex.equals("女")) {
                break;
            } else {
                System.out.println("请输入正确的性别:");
            }
        }
        System.out.println("请输入您的年龄：");
        int age = sca.nextInt();
        System.out.println("请输入您的密码：");
        String password = sca.next();
        StudentDAO.save(new Student(sid, sname, sex, age, password));
        System.out.println("恭喜注册成功，请返回登录");
        smenu();

    }

    /**
     * 学生登录
     */
    private void StudentLogin() {
        System.out.println("请输入学号:");
        int sid = sca.nextInt();
        boolean a = true;
        int time = 3;
        for (Student student : stu) {
            if (student.getSid() == sid) {
                a = false;
                while (time > 0) {
                    System.out.println("请输入密码:");
                    String password = sca.next();
                    if (student.getPassword().equals(password)) {
                        System.out.println("登陆成功");
                        studentShow(student.getSname(), sid);
                        break;
                    } else if (time > 1) {
                        System.out.println("密码错误请重新输入!!!");
                        time -= 1;
                        System.out.printf("您还有%d次机会!!!", time);
                    } else {
                        System.out.println("密码输入错误三次,自动关闭系统!!!");
                        System.exit(0);
                    }
                }

            }
            if (a) {
                System.out.println("账号不存在,请重新登陆");
                StudentLogin();

            }
        }
    }

    /**
     * 学生功能界面
     *
     * @param name 登录系统的学生姓名
     * @param sid  登录系统的学生学号
     */
    private void studentShow(String name, int sid) {
        System.out.printf("*************欢迎%s同学使用学生管理系统*************\n", name);
        System.out.println("请选择您要使用的功能:\n1.查询个人信息\n2.修改个人信息\n3.退出系统");
        int a = sca.nextInt();
        while (true) {
            switch (a) {
                case 1 -> searchMyself(sid);
                case 2 -> supdate(sid);
                case 3 -> System.exit(0);
                default -> System.out.println("请输入正确的指令");
            }
        }

    }

    /**
     * 学生查询自身信息
     *
     * @param sid 登录系统的学生学号
     */
    private void searchMyself(int sid) {
        Student stu = StudentDAO.findByNo(sid);
        assert stu != null;
        System.out.println(stu.toString());
        System.out.println("查询完成,是否继续使用本系统:0\\1  0:继续  1:退出");
        returnSmenu();
    }

    /**
     * 学生修改自身信息
     *
     * @param sid 登录系统的学生学号
     */
    private void supdate(int sid) {
        int i = updateInfo(sid);
        if (i >= 0) {
            System.out.println("修改成功,是否继续使用本系统:0\\1  0:继续  1:退出");
        } else {
            System.out.println("修改失败");
        }
        returnSmenu();
    }

    /**
     * 修改学生信息模块
     *
     * @param sid 需要修改的学生学号
     */
    private int updateInfo(int sid) {
        System.out.println("(Name:" + stu.get(sid).getSname() + ")请输入要修改的姓名:");
        String Sname = sca.next();
        System.out.println("(age:" + stu.get(sid).getAge() + ")请输入要修改的年龄:");
        int age = sca.nextInt();
        System.out.println("(sex:" + stu.get(sid).getSex() + ")请输入要修改的性别:");
        String sex;
        while (true) {
            sex = sca.next();
            if (sex.equals("男") || sex.equals("女")) {
                break;
            } else {
                System.out.println("请输入正确的数据:");
            }
        }
        System.out.println("(password:" + stu.get(sid).getPassword() + ")请输入要修改的密码:");
        String password = sca.next();
        return StudentDAO.merge(new Student(sid, Sname, sex, age, password));
    }

    /**
     * 管理员登录
     */
    private void ManagerLogin() {
        List<Manager> man = ManagerDAO1.findAll();
        for (Manager man1 : man) {
            System.out.println(man1.toString());
        }
        System.out.println("请输入管理员账号:");
        int mid = sca.nextInt();
        boolean a = true;
        for (Manager manager : man) {
            if (manager.getId() == mid) {
                a = false;
                int time = 3;
                while (time > 0) {
                    System.out.println("请输入密码:");
                    String password = sca.next();
                    if (password.equals(manager.getPassword())) {
                        System.out.println("登陆成功");
                        managerShow(manager.getName());
                        break;
                    } else if (time > 1) {
                        time--;
                        System.out.println("密码输入错误,请重新输入!!!");
                    } else {
                        System.out.println("密码输入错误超过三次,系统自动关闭!!!");
                        System.exit(0);
                    }
                }
            }
        }
        if (a) {
            System.out.println("管理员账号不存在,请重新输入!!!");
            ManagerLogin();
        }
    }

    /**
     * 管理员功能展示界面
     *
     * @param name 管理员姓名
     */
    private void managerShow(String name) {
        System.out.printf("*************欢迎管理员:%s使用学生管理系统*************\n", name);
        System.out.println("请选择您要使用的功能:\n1.增添学生\n2.删除学生\n3.修改学生\n4.查询学生\n5.增添管理员账号\n6.修改管理员信息\n7.删除管理员\n8.退出系统");
        while (true) {
            int a = sca.nextInt();
            switch (a) {
                case 1 -> addStudent(name);
                case 2 -> deleteStudent(name);
                case 3 -> updateStudent(name);
                case 4 -> findStudent(name);
                case 5 -> addManager(name);
                case 6 -> updateManager(name);
                case 7 -> deleteManager();
                case 8 -> System.exit(0);
                default -> System.out.println("请输入正确的指令");
            }
        }
    }

    /**
     * 添加学生功能
     *
     * @param name 管理员姓名
     */
    @SuppressWarnings("InfiniteLoopStatement")
    private void addStudent(String name) {
        System.out.println("请输入您要添加的学号:");
        int sid = sca.nextInt();
        for (Student student : stu) {
            if (student.getSid() == sid) {
                System.out.println("该学号已存在，请重新输入!!!");
                addStudent(name);
            }
        }
        System.out.println("请输入您要添加的姓名:");
        String sname = sca.next();
        System.out.println("请输入您要添加的性别:");
        String sex;
        while (true) {
            sex = sca.next();
            if (sex.equals("男") || sex.equals("女")) {
                break;
            } else {
                System.out.println("请输入正确的性别:");
            }
        }
        System.out.println("请输入您要添加的年龄：");
        int age = sca.nextInt();
        System.out.println("请输入您要添加的密码：");
        String password = sca.next();
        if (StudentDAO.save(new Student(sid, sname, sex, age, password)) >= 0) {
            System.out.println("恭喜添加成功，是否继续添加:0\\1  0:继续  1:退出");
        } else {
            System.out.println("添加失败");
        }

        while (true) {
            int a = sca.nextInt();
            switch (a) {
                case 0:
                    addStudent(name);
                    break;
                case 1:
                    managerShow(name);
                default:
                    System.out.println("请输入正确的指令:");
            }
        }
    }

    /**
     * 删除学生功能
     *
     * @param name 管理员姓名
     */
    private void deleteStudent(String name) {
        System.out.println("请输入您要删除的学生号:");
        int sid = sca.nextInt();
        boolean a = true;
        for (Student student : stu) {
            if (student.getSid() == sid) {
                a = false;
                if (StudentDAO.delete(sid) >= 0) {
                    System.out.println("删除成功");
                    managerShow(name);
                } else {
                    System.out.println("删除失败");
                }
            }
        }
        if (a) {
            System.out.println("学号不存在 无需删除");
            managerShow(name);
        }

    }

    /**
     * 修改学生信息
     *
     * @param name 管理员姓名
     */
    private void updateStudent(String name) {
        System.out.println("请输入您要修改的学号:");
        int id = sca.nextInt();
        boolean a = true;
        for (int sid = 0; sid < stu.size(); sid++) {
            if (stu.get(sid).getSid() == id) {
                a = false;
                if (updateInfo(sid) < 0) {
                    System.out.println("修改失败");
                }
                updateResult(name);
            }
        }
        if (a) {
            System.out.println("此学号不存，请重新输入");
            updateStudent(name);
        }

//		
    }

    /**
     * 查找学生
     *
     * @param name 管理员姓名
     */
    @SuppressWarnings("InfiniteLoopStatement")
    private void findStudent(String name) {
        System.out.println("请输入您要查询的方式:\n1.全部学生查询\n2.单个学生查询\n3.管理员查询\n4.退出");
        while (true) {
            int a = sca.nextInt();
            switch (a) {
                case 1 -> {
                    List<Student> list = StudentDAO.findAll();
                    for (Student stu : list) {
                        System.out.println(stu.toString());
                    }
                    System.out.println("查询完成");
                    findStudent(name);
                }
                case 2 -> {
                    System.out.println("请输入您要查询的学号:");
                    int id = sca.nextInt();
                    for (Student student : stu) {
                        if (student.getSid() == id) {
                            System.out.println(student.toString());
                        }
                    }
                    System.out.println("查询完成");
                    findStudent(name);
                }
                case 3 -> {
                    List<Manager> mlist = ManagerDAO1.findAll();
                    for (Manager man : mlist) {
                        System.out.println(man.toString());
                    }
                    System.out.println("查询完成");
                    findStudent(name);
                }
                case 4 -> managerShow(name);
                default -> System.out.println("请输入正确指令:");
            }
        }

    }

    /**
     * 增添管理员
     *
     * @param name 管理员姓名
     */
    @SuppressWarnings("InfiniteLoopStatement")
    private void addManager(String name) {
        System.out.println("请输入您要添加的管理员id:");
        int mid = sca.nextInt();
        for (Manager manager : man) {
            if (manager.getId() == mid) {
                System.out.println("该id已存在，请重新输入!!!");
                addManager(name);
            }
        }

        System.out.println("请输入您要添加的姓名:");
        String sname = sca.next();
        System.out.println("请输入您要添加的密码：");
        String password = sca.next();
        if (ManagerDAO1.save(new Manager(mid, sname, password)) >= 0) {
            System.out.println("恭喜添加成功，是否继续添加:0\\1  0:继续  1:退出");
        } else {
            System.out.println("添加失败");
        }
        while (true) {
            int a;
            try {
                a = sca.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("请输入正确的指令：");
                continue;
            }
            switch (a) {
                case 0:
                    addManager(sname);
                    break;
                case 1:
                    managerShow(name);
                default:
                    System.out.println("请输入正确的指令:");
            }
        }
    }

    /**
     * 修改管理员信息
     *
     * @param name 管理员姓名
     */
    private void updateManager(String name) {
        System.out.println("请输入您要修改的id:");
        int id = sca.nextInt();
        boolean a = true;
        for (Manager manager : man) {
            if (manager.getId() == id) {
                a = false;
                System.out.println("(Name:" + manager.getName() + ")请输入要修改的姓名:");
                String Mname = sca.next();
                System.out.println("(password:" + manager.getPassword() + ")请输入要修改的密码:");
                String password = sca.next();
                if (ManagerDAO1.merge(new Manager(id, Mname, password)) < 0) {
                    System.out.println("修改失败");
                }
                updateResult(name);
            }
        }
        if (a) {
            System.out.println("此学号不存，请重新输入");
            updateStudent(name);
        }

//		
    }

    /**
     * 删除管理员
     */
    private void deleteManager() {
        System.out.println("请输入您要删除的管理员id");
        int id = sca.nextInt();
        if (ManagerDAO1.delete(id) >= 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 修改完成返回主菜单
     */
    public void returnSmenu() {
        while (true) {
            int a = sca.nextInt();
            switch (a) {
                case 0 -> menu();
                case 1 -> System.exit(0);
                default -> System.out.println("请输入正确的指令:");
            }
        }
    }

    /**
     * 修改结果提示
     *
     * @param name 管理员密码
     */
    private void updateResult(String name) {
        System.out.println("修改成功,是否继续使用本系统:0\\1  0:继续  1:退出");
        while (true) {
            int b = sca.nextInt();
            switch (b) {
                case 0 -> managerShow(name);
                case 1 -> System.exit(0);
                default -> System.out.println("请输入正确指令:");
            }
        }
    }
}
