/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

import lombok.Builder;

/**
 *
 * @author LENOVO
 */
public class User {
    private String username;
    private String password;
    private boolean enabled;
    private String fullname;
    @Builder.Default
    private String photo = "photo.png";
    private boolean manager;
}
