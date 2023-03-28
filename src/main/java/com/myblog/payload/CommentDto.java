package com.myblog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {
    private Long id;
    @NotEmpty
    @Size(min = 2,message = "name should have at last 2 character")
    private String name;

    @NotEmpty
    @Size(min = 5,message = "name should have at last 5 character")
    private String body;
    @NotEmpty
    @Email
    private String email;

}
