
<br/>
<p align="center">
<img src="https://user-images.githubusercontent.com/41302353/236610169-5ce60454-2c7a-42f7-ac0c-515d4c915ea5.png" width="200" height="200" align>
</p>
<h3 align="center">MHLSQParking</h3>

<p align="center">
    A Java application that facilitates parking management and payment for users.
    <br/>
    <br/>
</p>

![License](https://img.shields.io/github/license/alexmihalascu/mhlsqparking)

## 🛠️ Built With
Java

## 📸 Project Screenshots

![java1](https://user-images.githubusercontent.com/41302353/236610011-d35ae41c-fa62-4a1f-af09-ba2b28b77e67.png)
![java2](https://user-images.githubusercontent.com/41302353/236610023-4313309a-8553-43ed-ad0c-d5f042870493.png)
![java3](https://user-images.githubusercontent.com/41302353/236610046-55730f4d-4e93-446a-aa7e-b6fca229a7bf.png)
![java4](https://user-images.githubusercontent.com/41302353/236610054-05ec5264-117d-4c98-8566-3a3886706d31.png)
![java5](https://user-images.githubusercontent.com/41302353/236610069-08ae7360-23bd-4ab7-81ad-62fb95cd7eb7.png)
![java6](https://user-images.githubusercontent.com/41302353/236610080-976c4d21-e646-4794-a76d-df82285483b0.png)

## 🚀 Getting Started

1. **Clone the repository** to your local development environment:
   ```bash
   git clone https://github.com/alexmihalascu/mhlsqparking.git
   ```

2. **Open the project** in a Java-compatible IDE, such as Eclipse or IntelliJ IDEA.

3. **Compile and run** the `Aplicatie.java` file.

## 🎮 Application Usage

- **Open the application** and log in with credentials from the `users.csv` file. To add a new user, add a new line in the format `(username, password)` to `users.csv`.
  
- Navigate the application's main menu to access features:
  - Issue Ticket
  - Manage Parking
  - Exit

- In the "Issue Ticket" section, enter the car's license plate number and parking duration. Choose a payment method and complete the required details.

- In the "Manage Parking" section, view and manage parking tickets and cars in the parking area.

## 🔧 Possible Modifications

- To change the parking capacity, go to `Aplicatie.java` and modify the line `Parcare parcare = new Parcare(100);` with the desired value.
- To adjust the parking rate, go to `PlataDialog.java` and modify the line `int totalPlata = durata * 3;` with the desired rate.

## ✍️ Authors

* **Alex Mihalașcu** - [Alex Mihalașcu](https://github.com/alexmihalascu/)
