package com.example.demo.dtos;

import lombok.Data;

@Data
public class PostRequest {
    private String content;

    // Getter and Setter for content (must be present to access the content)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
