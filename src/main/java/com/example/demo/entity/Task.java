package com.example.demo.entity;
import com.example.demo.Enum.Status;
import com.example.demo.Enum.Type;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        private String title;

        @Enumerated(EnumType.STRING)
        private Type type;

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        @Enumerated(EnumType.STRING)
        private Status status;


        private LocalDateTime creationDate = LocalDateTime.now();





        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public Type getType() {
                return type;
        }

        public void setType(Type type) {
                this.type = type;
        }



        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }



        public LocalDateTime getCreationDate() {
                return creationDate;
        }

        public void setCreationDate(LocalDateTime creationDate) {
                this.creationDate = creationDate;
        }

}
