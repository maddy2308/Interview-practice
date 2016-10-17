import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Amazon2 {

    public static void main(String[] args) {
        System.out.println(movePlane("UDLL"));
        System.out.println(movePlane("8D2L"));
        System.out.println(movePlane("4D2RX"));
        System.out.println(movePlane("dDf"));
        System.out.println(movePlane("4D2LX"));
        System.out.println(movePlane("4D2L2X"));
    }

    static String movePlane(String command) {

        List<String> groups = new ArrayList<String>();
        String patternString = "\\d*[U|D|L|R|X]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(command);
        while (matcher.find()) {
            groups.add(matcher.group());
        }
        return isValidCommand(groups, command) ? movePlaneHelper(groups) : "(999,999)";
    }

    private static boolean isValidCommand(List<String> groups, String originalCommand) {
        int length = 0;
        for (String s : groups) {
            length += s.length();
        }
        return length == originalCommand.length();
    }

    private static String movePlaneHelper(List<String> groups) {
        List<String> cleanCommands = cleanCommand(groups);
        Point point = new Point(0, 0);
        for (String command : cleanCommands) {
            Separator instance = Separator.separate(command);
            point = changePosition(instance.unit, instance.uniDirection, point);

        }
        return point.toString();
    }

    private static List<String> cleanCommand(List<String> groups) {

        List<String> list = new ArrayList<String>();

        for (int counter = groups.size() - 1; counter >= 0; counter--) {
            if (groups.get(counter).contains("X")) {
                Separator instance = Separator.separate(groups.get(counter));
                counter -= instance.unit;
                if (counter < 0) {
                    break;
                }
            } else {
                list.add(groups.get(counter));
            }
        }
        return list;
    }

    private static Point changePosition(int unit, char uniDirection, Point currentPosition) {
        switch (uniDirection) {
            case 'U':
                currentPosition.y += unit;
                break;
            case 'D':
                currentPosition.y -= unit;
                break;
            case 'L':
                currentPosition.x -= unit;
                break;
            case 'R':
                currentPosition.x += unit;
                break;
        }
        return currentPosition;
    }

    private static class Separator {
        int unit;
        char uniDirection;

        Separator(int unit, char uniDirection) {
            this.unit = unit;
            this.uniDirection = uniDirection;
        }

        static Separator separate(String command) {
            //\d+|[U|D|L|R]+
            Matcher matcher = Pattern.compile("\\d+|\\D+").matcher(command);
            int unit = 1;
            char uniDirection = 'A';
            while (matcher.find()) {
                if (matcher.group().matches("\\d+")) {
                    unit = Integer.parseInt(matcher.group());
                } else {
                    uniDirection = matcher.group().charAt(0);
                }
            }
            return new Separator(unit, uniDirection);
        }
    }


    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
