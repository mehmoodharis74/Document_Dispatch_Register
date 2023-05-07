// Define sample data class
class Record {
    constructor(studentId, appId, docId, applicantName, department, type,priority, status) {
      this.studentId = studentId;
      this.appId = appId;
      this.docId = docId;
      this.applicantName = applicantName;
      this.department = department;
      this.type = type;
      this.priority = priority;
      this.status = status;
    }
  }
  const maxCount = 100;
//----------------array of names-----------
const firstNames = [
    "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Mia", "Charlotte", "Amelia",
    "Harper", "Evelyn", "Abigail", "Emily", "Elizabeth", "Mila", "Ella", "Avery",
    "Sofia", "Camila", "Aria", "Scarlett", "Victoria", "Madison", "Luna", "Grace",
    "Chloe", "Penelope", "Layla", "Riley", "Zoey", "Nora", "Lily", "Eleanor",
    "Hannah", "Lillian", "Addison", "Aubrey", "Ellie", "Stella", "Natalie", "Zoe",
    "Leah", "Hazel", "Violet", "Aurora", "Savannah", "Audrey", "Brooklyn", "Bella",
    "Claire", "Skylar", "Lucy", "Paisley", "Everly", "Anna", "Caroline", "Nova",
    "Genesis", "Emilia", "Kennedy", "Samantha", "Maya", "Willow", "Kinsley", "Naomi",
    "Aaliyah", "Elena", "Sarah", "Ariana", "Allison", "Gabriella", "Alice", "Madelyn",
    "Cora", "Ruby", "Eva", "Serenity", "Autumn", "Adeline", "Hailey", "Gianna",
    "Valentina", "Isla", "Eliana", "Quinn", "Nevaeh", "Ivy", "Sadie", "Piper",
    "Lydia", "Alexa", "Josephine", "Emery", "Julia", "Delilah", "Arianna", "Vivian",
    "Kaylee", "Sophie", "Brielle", "Madeline", "Peyton", "Rylee", "Clara", "Hadley"
  ];
  
  const generatedFirstNames = [];
  for (let i = 0; i < maxCount; i++) {
    const index = Math.floor(Math.random() * firstNames.length);
    const firstName = firstNames.splice(index, 1)[0];
    generatedFirstNames.push(firstName);
  }

//array of student Id
const batchNumbers = ["22", "21", "20", "19", "18"];
const campuses = ["I", "L", "F", "K", "P"];
const studentIds = [];

for (let i = 0; i < maxCount; i++) {
  const batch = batchNumbers[Math.floor(Math.random() * batchNumbers.length)];
  const campus = campuses[Math.floor(Math.random() * campuses.length)];
  const randomNum = Math.floor(Math.random() * 10000).toString().padStart(4, "0");
  const studentId = batch + campus + "-" + randomNum;
  studentIds.push(studentId);
}
//application id
// Declare an empty array to store the application IDs
let applicationIds = [];

// Define a function to generate a random 5-digit number
function generateRandomNumber() {
  return Math.floor(Math.random() * 90000) + 10000;
}

// Loop to generate 100 unique application IDs
while (applicationIds.length < maxCount) {
  let randomId = generateRandomNumber();
  if (!applicationIds.includes(randomId)) {
    applicationIds.push(randomId);
  }
}
//document id
let docIds = [];

while (docIds.length < maxCount) {
  let newDocId = '';
  for (let i = 0; i < 5; i++) {
    if (Math.random() < 0.5) {
      newDocId += String.fromCharCode(Math.floor(Math.random() * 26) + 65); // add a random uppercase letter
    } else {
      newDocId += Math.floor(Math.random() * 10); // add a random digit
    }
  }
  if (!docIds.includes(newDocId)) {
    docIds.push(newDocId); // add the new doc ID to the array if it's unique
  }
}
// applicantion type
const types = ['Apply For Degree', 'Apply For Transcript', 'Change Grade', 'Advance Salary', 'Retake Exams', 'Financial Loan'];
const typeArray = [];

for (let i = 0; i < maxCount; i++) {
  const randomIndex = Math.floor(Math.random() * types.length);
  typeArray.push(types[randomIndex]);
}



//status array
const statuses = Array.from({length: maxCount}, () => Math.random() < 0.5 ? "pending" : "completed");

// department array
const departments = [
    "Computer Science","Artificial Intelligence","Software Engineering","Electrical Engineering","BBA","Data Science","FSM","CyberSecurity"
  ];
  
  const department = Array.from({length: maxCount}, () => {
    const index = Math.floor(Math.random() * departments.length);
    return departments[index];
  });
  
  // Create an array of records
  const priorities = [];
const priorityOptions = ["Urgent", "Normal"];

for(let i=0; i<100; i++){
  const priorityIndex = Math.floor(Math.random() * priorityOptions.length);
  const priority = priorityOptions[priorityIndex];
  priorities.push(priority);
}



  



  const records = [];
  for (let i = 1; i <= maxCount; i++) {
    //now push record and pick values from arrays
    records.push(new Record(studentIds[i - 1], applicationIds[i - 1], docIds[i - 1], generatedFirstNames[i - 1],department[i-1], typeArray[i - 1], priorities[i-1], statuses[i - 1]));
  }
  
  // Get the table body element
  const tableBody = document.querySelector("#grdUser tbody");
  const no_data = document.getElementById("no_data");
  // Loop through each record and generate a table row with the data
  //call generate table function when page loads


// generateTable(records);
  function generateTable(records) {
   
    // Clear the table body
    tableBody.innerHTML = "";
  var startIndex = 1;
  for (const record of records) {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td colspan="1">${startIndex}</td>
      <td colspan="1">${record.studentId}</td>
      <td colspan="1">${record.appId}</td>
      <td colspan="1">${record.docId}</td>
      <td colspan="1">${record.applicantName}</td>
      <td colspan="1">${record.department}</td>
      <td colspan="1">${record.type}</td>
      <td colspan="1">${record.priority}</td>
      <td colspan="1">${record.status}</td>
    `;
    tableBody.appendChild(row);
    startIndex++;
  }
}


  function searchRecord() {
    // Get the selected dropdown option
    var dropDownOption = document.getElementById("drop_down_req_menu").value;
    
    // Get the user input
    var userInput = document.getElementById("view_req_detail").value.trim();
    
    // Create a new array to store the matching records
    var matchingRecords = [];
    
    // Loop through the records array and search for matches
    for (var i = 0; i < records.length; i++) {
      var record = records[i];
      
      // Check if the current record matches the selected dropdown option and user input
      if ((dropDownOption === "studentId" && record.studentId === userInput) ||
          (dropDownOption === "sdname" && record.applicantName.toLowerCase().includes(userInput.toLowerCase())) ||
          (dropDownOption === "appId" && record.appId === userInput) ||
          (dropDownOption === "docId" && record.docId === userInput) ||
          (dropDownOption === "Department" && record.department.toLowerCase().includes(userInput.toLowerCase())) ||
          (dropDownOption === "appType" && record.appType.toLowerCase().includes(userInput.toLowerCase())) ||
          (dropDownOption === "status" && record.status.toLowerCase().includes(userInput.toLowerCase()))) {
        // Add the matching record to the new array
        matchingRecords.push(record);
        //if dropdown option is student id , app id or doc id then break the loop
        if(dropDownOption === "studentId" || dropDownOption === "appId" || dropDownOption === "docId"){
            break;
            }
      }
    }
    
    // Check if any matching records were found
    if (matchingRecords.length > 0) {
    no_data.style.display = "none";
   
  }
    else {
      // Show an error message if no matching records were found
      no_data.style.display = "block";
      //maken input field empty and its ring color red
      document.getElementById("view_req_detail").style.borderColor = "red";
      document.getElementById("view_req_detail").value = "";
      //on focus make ring color blue
    }
    generateTable(matchingRecords);

    document.getElementById("view_req_detail").addEventListener("focus", function(){
      document.getElementById("view_req_detail").value = "";
      document.getElementById("view_req_detail").style.borderColor = "blue";
    });
}
