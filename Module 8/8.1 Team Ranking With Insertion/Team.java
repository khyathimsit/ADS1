class Team {
	String name;
	int wins;
	int losses;
	int draw;

	Team (String name, int wins, int losses, int draw) {
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.draw = draw;
	}

	public String getName() {
		return this.name;
	}

	public int getWins() {
		return this.wins;
	}

	public int getLosses() {
		return this.losses;
	}
	
	public int getDraw() {
		return this.draw;
	}

	public int compareTo(Team that) {
		if (this.getWins() > that.getWins()) {
			return 1;
		} else if (this.getWins() < that.getWins()) {
			return -1;
		} else {
			if (this.getLosses() > that.getLosses()) {
				return -1;
			} else if (this.getLosses() < that.getLosses()) {
				return 1;
			} else {
				if (this.getDraw() > that.getDraw()) {
					return 1;
				} else if (this.getDraw() < that.getDraw()) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
}
