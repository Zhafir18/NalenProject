package com.NalenWebsite.dto.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterUserDTO {
    @NotBlank(message = "Username wajib diisi")
    @Size(max = 100, message = "Maksimal 100 Karakter")
    private String username;

    @NotBlank(message = "Password wajib diisi")
    @Size(min = 5, message = "Password minimal 5 karakter")
    private String password;

    @NotBlank(message = "Confirm password wajib diisi")
    @Size(min = 5, message = "Confirm password minimal 5 karakter")
    private String confirmPassword;

    @NotBlank(message = "Email wajib diisi")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Email tidak valid")
    private String email;

    @NotBlank(message = "Nomor telepon wajib diisi")
    @Pattern(regexp = "[0-9]+$", message = "Nomor telepon tidak valid")
    private String phoneNumber;
}
