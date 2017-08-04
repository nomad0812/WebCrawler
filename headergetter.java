import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.Scanner;

public class headergetter{

  public static void main(String[] args){

    //String text = "<title>Jacks site</title>";

    //System.out.println(titleExtr(text));
    //System.out.println(text.charAt(bg));
    //System.out.println(text.charAt(end+bg-1));

    String title = "[!]No title found";

    String site = args[0];

    try{
      URL url = new URL(site);

      Scanner s2 = new Scanner(url.openStream());

      //loop through each line and check if it contains the title tag and then if so extract the title from the line
      while(s2.hasNext()){

        String current = s2.nextLine();

        if(current.contains("<title>")){
          title = titleExtr(current);
          System.out.println("[*]Title Found");
        }

      }
    }
    catch(MalformedURLException e){
      System.out.println("[!]Error in url");
    }
    catch(IOException e){
      System.out.println("[!]IO Exception occurred");
    }
    finally{
      System.out.println("[+]"+title);
    }


  }

  public static String titleExtr(String text){

    //find begin index
    int bg = text.indexOf("<title>") + 7;

    //finds end index
    int end = (text.substring(bg,text.length()).indexOf("</title>")) + (bg);

    //a substring of the title
    String title = text.substring(bg, end);

    return title;

  }

}
