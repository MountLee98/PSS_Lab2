package lab.pai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser")
    private Long userId;
	@Column(name = "companyName", nullable = false)
    private String companyName;
	@Column(name = "companyAddress", nullable = false)    
	private String companyAddress;
	@Column(name = "companyNipe", nullable = false)
    private String companyNip;
	@Column(name = "name", nullable = false)
    private String name;    
	@Column(name = "lastName", nullable = false)
    private String lastName;
	@Column(name = "email", nullable = false)
    private String email;
	@Column(name = "password", nullable = false)
    private String password;
    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status;
    @Column(name = "registrationName", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime registrationDate; 
//    @Column(columnDefinition = "role default role_user")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    @Column(name = "role")
    private List<Role> role;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "delegation")
    private List<Delegation> delegation;
    
    public User(){
        delegation = new ArrayList<>();
        role = new ArrayList<>();
    }
    
    public User(String companyName, String companyAddress, String companyNip, String name, String lastName, String email,
			String password) {
    	this.companyName = companyName;
    	this.companyAddress = companyAddress;
        this.companyNip = companyNip;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        
        delegation = new ArrayList<>();
        role = new ArrayList<>();
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyNip() {
		return companyNip;
	}
	public void setCompanyNip(String companyNip) {
		this.companyNip = companyNip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public List<Delegation> getDelegation() {
		return delegation;
	}
	public void setDelegation(List<Delegation> delegation) {
		this.delegation = delegation;
	}
}
