class Sorting {
	Sorting() {
    }
    public Student[] sort(Student[] s) {
    	Student[] student = s;
    	for (int i = 0;i < student.length; i++) {
            int min = i;
            for (int j = i + 1; j < student.length; j++) {
            	if (student[min].getTotal() < student[j].getTotal()) {
            		min = j;
            	} else if (student[min].getTotal()
				           == student[j].getTotal()) {
					if (student[min].getMarks3()
					        < student[j].getMarks3()) {
						min = j;
					} else if (student[min].getMarks3()
					           == student[j].getMarks3()) {
						if (student[min].getMarks2()
						        < student[j].getMarks2()) {
							min = j;
						// } else if (student[min].getMarks2()
						//            == student[j].getMarks2()) {
						// 	if (student[min].getDOB() < student[j].getDOB()) {
						// 		min = j;
						// 	}
						}
					}
				}
			}
			if (min != i){
				swap(student, i, min);
			}
		}
		return student;
	}
	
	public void swap(Student[] s, int i, int min) {
        Student temp = s[min];
        s[min] = s[i];
        s[i] = temp;
    }
}

	// public void selection() {
    //     for (int i = 0;i < size; i++) {
    //         int min = i;
    //         for (int j = i + 1; j < size; j++) {
    //             if (student[j].compareTo(student[min]) > -1) {
    //                 min = j;
    //             }
    //         }
    //         swap(student, i, min);
    //     }
    // }
