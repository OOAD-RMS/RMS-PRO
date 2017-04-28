public class Table {

private boolean mOccupied;

//private int mCustomerId;

public Table(){

mOccupied = false;

}

public boolean isOccupied(){

return

mOccupied == true;

}

public void bookTable(){

mOccupied = true;

}

public void releaseTable(){

mOccupied = false;

}

}