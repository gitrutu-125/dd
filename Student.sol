// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;
contract StudentData {
 // Structure
 struct Student {
 string name;
 uint256 rollno;
 }
 // Array
 Student[] public studentarr;
 function addStudent(string memory name, uint rollno) public {
 for (uint i = 0; i < studentarr.length; i++) {
 if (studentarr[i].rollno == rollno) {
 revert("Student with this roll no already exists");
 }
 }
 studentarr.push(Student(name, rollno));
 }
 function getStudentsLength() public view returns (uint) {
 return studentarr.length;
 }
 function displayAllStudents() public view returns (Student[] memory) {
 return studentarr;
 }
 function getstudentByIndex(uint idx) public view returns (Student memory) {
 require(studentarr.length > idx, "index out of bound");
 return studentarr[idx];
 }
 // Fallback
 fallback() external payable {
 // This function will handle an external function call
 // that is not there in our contract.
 }
 receive() external payable {
 // This function will handle the Ether sent by an external user
 // without data mentioned.
 }
}