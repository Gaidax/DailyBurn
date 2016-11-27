package com.example.dailyburn;

import java.util.Date;

/**
 * Created by Rukshar on 2016-11-25.
 */

public class ItemProfileInfo {
    //Id, currentVersion, Name, weight, height, gender, created, role (datetime), used until (datetime)
    //changes to the survey result in another profile item with another version id, together they are

    private int profileId;
    private int currentVersion;
    private String profileName;
    private float weightKg;
    private float heightCm;
    private int age;
    private String gender;
    private String role;
    private String allergy;
    private Date dayCreated;
    private Date dayReplaced;


    public ItemProfileInfo(){}

    public ItemProfileInfo(int _profileId, int _currentVersion, String _profileName, float _weightLB, float _heightCm, int _age, String _gender, String _role, String _allergy, Date _dayCreated, Date _dayReplaced){
        this.profileId = _profileId;
        this.currentVersion = _currentVersion;
        this.profileName = _profileName;
        this.weightKg = _weightLB;
        this.heightCm = _heightCm;
        this.age = _age;
        this.gender = _gender;
        this.role = _role;
        this.allergy = _allergy;
        this.dayCreated = _dayCreated; //2016/12/12 12:12:12 am
        this.dayReplaced = _dayReplaced;
    }

    public ItemProfileInfo(int _currentVersion, String _profileName, float _weightLB,float _heightCm, int _age, String _gender, String _role, String _allergy,Date _dayCreated, Date _dayReplaced){
        this.currentVersion = _currentVersion;
        this.profileName = _profileName;
        this.weightKg = _weightLB;
        this.heightCm = _heightCm;
        this.age = _age;
        this.gender = _gender;
        this.role = _role;
        this.allergy = _allergy;
        this.dayCreated = _dayCreated;
        this.dayReplaced = _dayReplaced;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(int currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public float getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(float weightKg) {
        this.weightKg = weightKg;
    }

    public float getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(float heightCm) {
        this.heightCm = heightCm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public Date getDayCreated() {
        return dayCreated;
    }

    public void setDayCreated(Date dayCreated) {
        this.dayCreated = dayCreated;
    }

    public Date getDayReplaced() {
        return dayReplaced;
    }

    public void setDayReplaced(Date dayReplaced) {
        this.dayReplaced = dayReplaced;
    }
}
/*public class ItemProfileInfo {
    //Id, currentVersion, Name, weight, height, gender, created, role (datetime), used until (datetime)
    //changes to the survey result in another profile item with another version id, together they are

    private int profileId;
    private int currentVersion;
    private String profileName;
    private float weightKg;
    private int age;
    private String gender;
    private String role;
    private Date dayCreated;
    private Date dayReplaced;


    public ItemProfileInfo(){}

    public ItemProfileInfo(int _profileId, int _currentVersion, String _profileName, float _weightLB, int _age, String _gender, String _role, Date _dayCreated, Date _dayReplaced){
        this.profileId = _profileId;
        this.currentVersion = _currentVersion;
        this.profileName = _profileName;
        this.weightKg = _weightLB;
        this.age = _age;
        this.gender = _gender;
        this.role = _role;
        this.dayCreated = _dayCreated; //2016/12/12 12:12:12 am
        this.dayReplaced = _dayReplaced;
    }

    public ItemProfileInfo(int _currentVersion, String _profileName, float _weightLB, int _age, String _gender, String _role, Date _dayCreated, Date _dayReplaced){
        this.currentVersion = _currentVersion;
        this.profileName = _profileName;
        this.weightKg = _weightLB;
        this.age = _age;
        this.gender = _gender;
        this.role = _role;
        this.dayCreated = _dayCreated;
        this.dayReplaced = _dayReplaced;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(int currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public float getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(float weightKg) {
        this.weightKg = weightKg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDayCreated() {
        return dayCreated;
    }

    public void setDayCreated(Date dayCreated) {
        this.dayCreated = dayCreated;
    }

    public Date getDayReplaced() {
        return dayReplaced;
    }

    public void setDayReplaced(Date dayReplaced) {
        this.dayReplaced = dayReplaced;
    }
}*/
/*public class ItemProfileInfo {
}*/
