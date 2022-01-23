package code._4_student_effort.hard._1_decorations;

public class DecorationCandy extends Decoration {
    public DecorationCandy(int positionInTree, DecorableTree christmasTree) { super(positionInTree, christmasTree); }

    @Override
    public String getDecoration() { return "C"; }
}
