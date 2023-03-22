package ch8;

/* 
 * You have an array in which certain elements mean different things
 * 
 * Replace the array with an object that has a field for each element
 * 
 */
class ReplaceArrayWithObject {
  public static void client() {
    String[] row = new String[3];
    row[0] = "Liverpool";
    row[1] = 15;
  }
}

class Performance {
  private String _name = "";
  private String _wins = "";

  public void setName(String arg) {
    _name = arg;
  }

  public String getName() {
    return _name;
  }

  public void setWins(String arg) {
    _wins = arg;
  }

  public String getWins() {
    return _wins;
  }
}

class ReplaceArrayWithObjectRefactored {
  public static void client() {
    Performance row = new Performance();
    row.setName("Livepool");
    row.setWins("15");
  }
}
