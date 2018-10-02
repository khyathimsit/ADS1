class SelectionSort {
    Team[] team;
    int size;
    SelectionSort() {
        team = new Team[20];
        this.size = 0;
    }
    
    public void add(Team t) {
        team[size++] = t;
    }

    public int size() {
        return size;
    }

    public void selection() {
        for (int i = 0;i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (team[j].compareTo(team[min]) > -1) {
                    min = j;
                }
            }
            swap(team, i, min);
        }
    }

    public void swap(Team[] team, int i, int min) {
        Team temp = team[min];
        team[min] = team[i];
        team[i] = temp;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size - 1; i++) {
            str += team[i].getName() + ",";
        }
        str += team[size - 1].getName();
        return str;
    }
}