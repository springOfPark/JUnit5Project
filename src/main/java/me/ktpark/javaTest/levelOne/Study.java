package me.ktpark.javaTest.levelOne;

public class Study {

    private String name;

    private StudyStatus studyStatus;

    private int limit;

    public Study() { }

    public Study(int limit, String name) {
        this.name = name;
        this.limit = limit;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("LIMIT은 0보다 커야한다.");
        }
        this.limit = limit;
    }

    public Object getStatus() {
        return this.studyStatus;
    }

    public StudyStatus getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(StudyStatus studyStatus) {
        this.studyStatus = studyStatus;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Study{" +
                "name='" + name + '\'' +
                ", studyStatus=" + studyStatus.name() +
                ", limit=" + limit +
                '}';
    }
}
