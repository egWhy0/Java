import java.util.*;
import java.io.*;
public class EqualityTest {
    ArrayList<Song> songList = new ArrayList<Song>();
    ArrayList<Song> songList1 = new ArrayList<Song>();
    public static void main(String[] args){
        new EqualityTest().test();
    }

    public void test(){
        // A, B 의 동치의 조건 : 1. A.hashCode() == B.hashCode() && 2. A.equal(B)

        // ArrayList에 add 전 해시코드
        System.out.println(songList.hashCode());
        System.out.println(songList1.hashCode());
        System.out.println(songList.equals(songList1));
        System.out.println(songList == songList1);
        System.out.println();
        // 1.
        getSongs();
        getSongs1();

        // 2.
        // getSongs();

        // ArrayList에 add 후 해시코드
        System.out.println(songList.hashCode());
        System.out.println(songList1.hashCode());
        System.out.println(songList.equals(songList1));
        System.out.println(songList == songList1);
        System.out.println();

        HashSet<Song> songSet = new HashSet<Song>();

        // 1. 서로 다른 객체를 넣은 songList, songList1
        // songList와 songList1은 서로 다른 힙 메모리에서 서로 다른 객체를 참조하는 객체들이 들어있다.
        // 객체동치(object equality)를 위해서 Song객체의 equals()와 hashCode()를 오버라이드해줘야한다.
        // 오버라이드를 해야지 Set에 addAll을 경우 중복 제거가 된다.
        {
            songSet.addAll(songList);
            System.out.println("add songList to songSet : " + songSet);

            songSet.addAll(songList1);
            System.out.println("add songList1 to songSet : " + songSet);
        }

        // songList에 서로 다른 객체를 넣고, songList1에 할당
        // songList와 songList1은 힙 메모리에 같은 객체를 참조하는 객체(Song)들이 들어있어 둘은 레퍼런스동치(reference equality)
        // Set에 addAll 할 경우 중복 제거가 된다.
        // {
        //     songList1 = songList;
        //     System.out.println(songList.hashCode());
        //     System.out.println(songList1.hashCode());
        //     System.out.println(songList == songList1);
        //     System.out.println(songList.equals(songList1));

        //     // songList, songList1은 레퍼런스(reference) 동치이므로 Set시 중복제거가 됨.
        //     songSet.addAll(songList);
        //     System.out.println(songSet);
        //     songSet.addAll(songList1);
        //     System.out.println(songSet);

        //     // 증명 Song객체에 equals 와 hashCode를 Override를 안해도된다.
        //     System.out.println("증명 1 : 0번 객체들 끼리의 eqals : " + songList.get(0).equals(songList1.get(0)) );
        //     System.out.println("증명 2 : 0번 객체들 끼리의 hashCode 비교 : " + songList.get(0).equals(songList1.get(0)) );
        // }

    }

    void getSongs(){
        try{
            File file = new File("SongListMore.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while( (line = reader.readLine()) != null ){
                addSong(line);
            }
            reader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");

        Song nextSong = new Song( tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }

    void getSongs1(){
        try{
            File file = new File("SongListMore.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while( (line = reader.readLine()) != null ){
                addSong1(line);
            }
            reader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    void addSong1(String lineToParse) {
        String[] tokens = lineToParse.split("/");

        Song nextSong = new Song( tokens[0], tokens[1], tokens[2], tokens[3]);
        songList1.add(nextSong);
    }


}