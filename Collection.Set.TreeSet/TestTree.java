/*

    집합을 정렬된 상태로 유지시키고 싶다면 TreeSet을 쓰면 된다.

    TreeSet은 중복을 방지해준다는 면에서 HashSet과 비슷하다. 하지만 정렬을 유지시켜주는 기능도 있다.
    인자가 없는 생성자를 이용해서 TreeSet을 만들면 객체의 compareTo() 메소드를 써서 자동으로 정렬된 집합을 만들어준다.
    그리고 생성자에 Comparator를 넘겨주면 그 객체의 compare()메소드를 써서 정렬을 해준다. 
    정렬을 하지 않아도 될 때도 항상 정렬을 하기 때문에 속도가 조금 느리다는 단점도 있지만, 대부분의 경우에 그 속도 저하를 거의 느끼기 힘들다.

*/

/*
    1) 이 코드를 컴파일하면 어떻게 될까
        Book 클래스에서는 Comparable을 구현하지 않아제대로 실행되지 않는다.
        TreeSet은 원소들을 정렬시키는 기능이 있지만 Book객체를 정렬하는 방법을 모르고 있기 때문이다.

    2) 컴파일하고 나서 TestTree 클래스를 실행하면 어떤 결과가 나올까.
        TreeSet의 add() 메소드의 인자 유형이 Comparable로 선언된 건 아니기 때문에 컴파일할 때는 오류가 나지 않는다.
            TreeSet을 만들 때 지정한 유형이라면 Comparable이 아니어도 상관이 없기 때문인데 
            즉, new TreeSet<Book>()라고 했다면 add() 메소드는 add(Book) 형태로 선언이 되는 셈이다.
            Book 클래스에서 Comparable을 구현해야 한다는 조건은 어디에도 없다. 
            하지만 사용자가 집합에 두 번째 원소를 집어넣으려고 하면 런타임 오류가 난다. 객체의 comparTo()메소드를 처음으로 호출하려고 하는데, 메소드가 없다보니 오류가 난다.

    3) (컴파일할 때나 실행할 때) 이 코드에 문제가 있다면 어떻게 고쳐야하나.
        TreeSet은 Collection.Sort() 메소드와 비슷하게 작동을 한다.
        1. 원소에서 Comparable을 구현하면 원소의 compareTo() 메소드를 써도 되고
        2. 집합에 들어갈 원소들을 정렬하는 방법을 알려주는 Comparator를 만들어서 전해줘도 된다. 
            Comparator를 사용하고 싶으면 Comparator를 인자로 받아들이는 오버로드된 TreeSet 생성자를 사용하면된다.

*/
import java.util.*;

//  1. Comparable을 구현
//  Comparable을 구현시 compareTo()는 오버라이드를 한번할 수있기 때문에 만약 author을 기준으로 정렬을 하고 싶다면 수정은 불가피하다.
/*
    class Book implements Comparable <book>{
        String title;
        String author;
        public Book(String t) {
            title = t;
        }
        public int compareTo(Object b) {
            Book book = (Book) b;
            return title.compareTo(book.title);
        }
    }

*/

//  2. Comparator를 구현
/*
    public class BookCompare implements Comparator<Book> {
        public int compare(Book one, Book two) {
            return (one.title.compareTo(two.title));
        }
    }
*/


class Book {
    String title;
    public Book(String t) {
        title = t;
    }
}



class TestTree{
    public static void main(String[] args){
        new TestTree().go();
    }

    public void go(){
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Boby");
        Book b3 = new Book("Finding Emo");

        // comparator를 만들어서 사용할 경우.
        // BookCompare bCompare = new BookCompare();

        TreeSet<Book> tree = new TreeSet<Book>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);

    }
}

