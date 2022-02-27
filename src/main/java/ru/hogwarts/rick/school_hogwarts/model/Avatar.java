package ru.hogwarts.rick.school_hogwarts.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Создать модель Avatar. В ней будем хранить аватарки студентов.
 * В модель добавить следующие поля:
 * Long id, String filePath, long fileSize, String mediaType, byte[] data, Student student.
 */
@Entity
public class Avatar {
    @Id
    @GeneratedValue
    private long id;

    private String filePath;
    private long filesize;
    private String mediaType;
    @Lob
    private byte[] data;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Avatar(long id, String filePath, long filesize, String mediaType, byte[] data) {
        this.id = id;
        this.filePath = filePath;
        this.filesize = filesize;
        this.mediaType = mediaType;
        this.data = data;
    }

    public Avatar() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", filesize=" + filesize +
                ", mediaType='" + mediaType + '\'' +
                ", data=" + Arrays.toString(data) +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return id == avatar.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
