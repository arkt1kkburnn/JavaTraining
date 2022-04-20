package org.nikita.people;

public class ReadCommand implements Command{
    Campus campus = new Campus();
    json json = new JsonImpl();
    String[][] sep1 = new String[6][6];

    public void exe(){
        String j = json.jread("C:/Users/Я/IdeaProjects/MyUniversity1/src/Student.json",campus).toString();
        j = j.substring(17,j.length()-2);
        String[] sep = j.split(",");
        //String[][] sep1 = new String[6][6];
        for (int i = 1;i< sep.length;i++){
            sep[i] = sep[i].substring(1);
        }
        for (int i = 0;i< sep.length;i++){
            String[] g = sep[i].split(" ");
            sep1[i] = g;
        }
    }
}
