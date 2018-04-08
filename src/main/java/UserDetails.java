package main.java;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;


@Entity
@NamedQuery(name="UserDetails.findAll", query="SELECT DISTINCT u FROM UserDetails u LEFT JOIN FETCH u.articles")
public class UserDetails {

    @Id
    @GeneratedValue
    private String userId;
    
    @Version
    private long version;
    
    @Column
    private String password;

    @Column
    private String name;
    
    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<Article> articles;
    
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date statusDate;
    
    public List<Article> getArticles() {
        return articles;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "UserDetails [userId=" + userId + ", password=" + password + ", name=" + name + ", userStatus="
                + userStatus + ", statusDate=" + statusDate + "]";
    }

  

    
}