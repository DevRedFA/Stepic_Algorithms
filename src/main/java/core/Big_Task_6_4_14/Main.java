package core.Big_Task_6_4_14;

import java.util.*;
import java.util.function.*;


public class Main {

    public static void main(String[] args) {
        // Random variables
        String randomFrom = "..."; // ��������� ��������� ������. ������ ������� �� ��������������.
        String randomTo = "...";  // ��������� ��������� ������. ������ ������� �� ��������������.
        int randomSalary = 100;  // ��������� ��������� ����� ������������� �����. ������ ������� ��� ��������������.

// �������� ������ �� ���� �������� ���������.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "����, ������ ��� ��� ������ ������ ����, ����� ����������� ��� �������� ������� �. ��� �� ������!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "� ��� � �� ����� ������������."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

// �������� ��������� �������.
        MailService<String> mailService = new MailService<>();

// ��������� ������ ����� �������� ��������
        messages.stream().forEachOrdered(mailService);

// ��������� � �������� ������� "��������� �����",
//   ��� �� ���������� ����� �������� ������ ���������, ������� ���� ��� ����������
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "����, ������ ��� ��� ������ ������ ����, ����� ����������� ��� �������� ������� �. ��� �� ������!",
                        "� ��� � �� ����� ������������."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


// �������� ������ �� ���� �������.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

// �������� ��������� �������, ��������������� ��������.
        MailService<Integer> salaryService = new MailService<>();

// ��������� ������ ������� �������� ��������
//        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

// ��������� � �������� ������� "��������� �����",
//   ��� �� ���������� ����� �������� ������ �������, ������� ���� ��� ����������.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
    }

    public static class MailMessage extends data<String> {
        public MailMessage(String from, String to, String content) {
            super(to, from, content);
        }
    }

    public static class Salary extends data<Integer> {
        public Salary(String from, String to, Integer content) {
            super(to, from, content);
        }
    }


    public static abstract class data<T> {
        private String to;
        private String from;

        public T getContent() {
            return content;
        }

        private T content;

        public data(String to, String from, T content) {
            this.to = to;
            this.from = from;
            this.content = content;
        }

        public String getTo() {
            return to;
        }

        public String getFrom() {
            return from;
        }
    }


    public static class MailService<T> implements Consumer<data<T>> {

        Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                return super.getOrDefault(key, new LinkedList<T>());
            }
        };

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }


        @Override
        public void accept(data<T> data) {
            mailBox.putIfAbsent(data.getTo(), new ArrayList<>());
            mailBox.get(data.getTo()).add((T) data.getContent());
        }
    }
}
