package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for(Thread th : threads){
            switch(th.getState()){
                case NEW: th.start(); break;
                case WAITING: th.interrupt(); break;
                case BLOCKED: th.interrupt(); break;
                case TIMED_WAITING: th.interrupt(); break;
                case RUNNABLE: th.isInterrupted(); break;
                case TERMINATED:
                    System.out.println(th.getPriority()); break;
            }

        }
    }
}
