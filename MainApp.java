/*
Authors: Tucker McCoy and Erick Ponce 
Program: Homework 1 
Date: 5/21/2018
Description: IS System for a small HVAC comapany that allows them to run their
daily operations smoothly
*/
package Homework1;

import Lecture1.Sprocket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

public class MainApp extends Application {

    // Our Database Connection method needs these 
    // objects. We declare them here and point them
    // to instance objects below.
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;

    // Storing data in memory:
    ArrayList<Customer> customerData = new ArrayList<>();
    ArrayList<Product> productData = new ArrayList<>();
    ArrayList<SalesPerson> salesPersonData = new ArrayList<>();
    ArrayList<Service> serviceData = new ArrayList<>();
    ArrayList<Store> storeData = new ArrayList<>();
    ArrayList<Technician> technicianData = new ArrayList<>();
    ArrayList<Supplier> supplierData = new ArrayList<>();
    ArrayList<Transaction> transactionData = new ArrayList<>();

    // TabPane and its Tabs
    TabPane tbPane = new TabPane();
    Tab tab1 = new Tab("Home");
    Tab tab2 = new Tab("Customer");
    Tab tab3 = new Tab("Product");
    Tab tab4 = new Tab("SalesPerson");
    Tab tab5 = new Tab("Service");
    Tab tab6 = new Tab("Store");
    Tab tab7 = new Tab("Supplier");
    Tab tab8 = new Tab("Technician");
    Tab tab9 = new Tab("Transaction");

    // GridPanes for organizing each Tab
    GridPane overallPane = new GridPane();
    GridPane homePane = new GridPane();
    GridPane customerPane = new GridPane();
    GridPane productPane = new GridPane();
    GridPane salesPersonPane = new GridPane();
    GridPane servicePane = new GridPane();
    GridPane storePane = new GridPane();
    GridPane supplierPane = new GridPane();
    GridPane technicianPane = new GridPane();
    GridPane transactionPane = new GridPane();
    HBox hbox = new HBox(5);

    // home controls
    Image imageLink = new Image("file:image/hvac.jpg");
    ImageView viewImage = new ImageView(imageLink);
    Image imageSocial = new Image("file:image/social.jpg");
    ImageView viewSocial = new ImageView(imageSocial);
    Label lblTitle = new Label("Welcome to the Shenandoah Valley \nHVAC/Residental Air Information System");
    Label lblFollow = new Label("Stay up to date by following our social media accounts: ");
    Label lblHours = new Label("Hours of Operation: \nMonday-Friday: 8am-6pm\nSaturday: 10am-5pm"
            + "\nContact Information: \nshenvalleyHVAC@gmail.com\n(540)568-2020");

    // customer controls
    Label lblCustomerInformation = new Label("Enter Customer Information to Add Below: ");
    Label lblCustomerName = new Label("Customer Name: ");
    TextField txtCustomerName = new TextField();
    Label lblCustomerPhone = new Label("Customer Phone Number ()xxx-xxxx: ");
    TextField txtCustomerPhone = new TextField();
    Label lblCustomerAddress = new Label("Customer Address: ");
    TextField txtCustomerAddress = new TextField();
    Label lblCustomerEmail = new Label("Customer Email: ");
    TextField txtCustomerEmail = new TextField();
    Button btnCreateCustomer = new Button("Create Customer");

    // product controls
    Label lblProductInformation = new Label("Enter Product Information to Add Below: ");
    Label lblProductName = new Label("Product Name: ");
    TextField txtProductName = new TextField();
    Label lblProductDescription = new Label("Product Description: ");
    TextField txtProductDescription = new TextField();
    Label lblProductPrice = new Label("Product Price: ");
    TextField txtProductPrice = new TextField();
    Button btnCreateProduct = new Button("Create Product");

    // salesperson controls
    Label lblSalesPersonInformation = new Label("Enter Sales Person Information to Add Below: ");
    Label lblSalesPersonName = new Label("SalesPerson Name: ");
    TextField txtSalesPersonName = new TextField();
    Label lblSalesPersonPhone = new Label("SalesPerson Phone Number ()xxx-xxxx: ");
    TextField txtSalesPersonPhone = new TextField();
    Label lblSalesPersonEmail = new Label("SalesPerson Email: ");
    TextField txtSalesPersonEmail = new TextField();
    Button btnCreateSalesPerson = new Button("Create SalesPerson");

    // service controls
    Label lblServiceInformation = new Label("Enter Service Information to Add Below: ");
    Label lblServiceName = new Label("Service Name: ");
    TextField txtServiceName = new TextField();
    Label lblServiceLevel = new Label("Residential or Commercial: ");
    TextField txtServiceLevel = new TextField();
    Label lblServicePrice = new Label("Service Price: ");
    TextField txtServicePrice = new TextField();
    Label lblAssignedTechnician = new Label("Technician Assigned to Service: ");
    TextField txtAssignedTechnician = new TextField();
    Button btnCreateService = new Button("Create Service");

    // store controls
    Label lblStoreInformation = new Label("Enter Store Information to Add Below: ");
    Label lblStoreName = new Label("Store Name: ");
    TextField txtStoreName = new TextField();
    Label lblStoreLocation = new Label("Store Location: ");
    TextField txtStoreLocation = new TextField();
    Label lblStoreAddress = new Label("Store Address: ");
    TextField txtStoreAddress = new TextField();
    Label lblStorePhoneNumber = new Label("Store Phone Number: ");
    TextField txtStorePhoneNumber = new TextField();
    Button btnCreateStore = new Button("Create Store");

    // supplier controls
    Label lblSupplierInformation = new Label("Enter Supplier Information to Add Below: ");
    Label lblSupplierName = new Label("Supplier Name: ");
    TextField txtSupplierName = new TextField();
    Label lblSupplierAddress = new Label("Supplier Address: ");
    TextField txtSupplierAddress = new TextField();
    Label lblSupplierPhoneNumber = new Label("Supplier Phone Number: ");
    TextField txtSupplierPhoneNumber = new TextField();
    Label lblSupplierEmail = new Label("Supplier Email: ");
    TextField txtSupplierEmail = new TextField();
    Button btnCreateSupplier = new Button("Create Supplier");

    // technician controls
    Label lblTechnicianInformation = new Label("Eneter Technician Information to Add Below: ");
    Label lblTechnicianName = new Label("Technician Name: ");
    TextField txtTechnicianName = new TextField();
    Label lblTechnicianStore = new Label("Technician Store: ");
    TextField txtTechnicianStore = new TextField();
    Label lblTechnicianPhoneNumber = new Label("Technician Phone Number: ");
    TextField txtTechnicianPhoneNumber = new TextField();
    Label lblTechnicianEmail = new Label("Technician Email: ");
    TextField txtTechnicianEmail = new TextField();
    Button btnCreateTechnician = new Button("Create Technician");

    // menu bar
    MenuBar mnuBar = new MenuBar();

    @Override
    public void start(Stage primaryStage) {
        ///////////////////MAIN MENU////////////////////////////////////////////
        overallPane.setAlignment(Pos.BASELINE_LEFT);
        homePane.setAlignment(Pos.CENTER);

        hbox.getChildren().add(mnuBar);
        homePane.add(viewImage, 1, 0);
        homePane.add(lblTitle, 0, 0, 1, 1);
        homePane.add(lblFollow, 0, 5);
        lblFollow.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC,
                15));
        homePane.add(viewSocial, 0, 6);
        homePane.add(lblHours, 0, 8);
        viewImage.setFitHeight(300);
        viewImage.setFitWidth(300);
        viewSocial.setFitHeight(100);
        viewSocial.setFitWidth(200);
        lblTitle.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC,
                25));
        lblTitle.setTextAlignment(TextAlignment.CENTER);
        homePane.setHgap(5);
        tab1.setContent(homePane);
        tbPane.getTabs().add(tab1);

        overallPane.add(hbox, 0, 0);
        overallPane.add(tbPane, 0, 1);

        Scene primaryScene = new Scene(overallPane, 750, 650);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Shenandoah Valley HVAC/Residential Air");
        primaryStage.show();

        tbPane.setMinHeight(primaryScene.getHeight());
        tbPane.setMinWidth(primaryScene.getWidth());
        tab1.setClosable(false);

        /////////////////////////CUSTOMER TAB///////////////////////////////////
        customerPane.setAlignment(Pos.CENTER);
        customerPane.add(lblCustomerInformation, 0, 0);
        lblCustomerInformation.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.ITALIC,
                20));
        lblCustomerInformation.setTextAlignment(TextAlignment.CENTER);
        customerPane.add(lblCustomerName, 0, 1);
        customerPane.add(txtCustomerName, 1, 1);
        customerPane.add(lblCustomerPhone, 0, 2);
        customerPane.add(txtCustomerPhone, 1, 2);
        customerPane.add(lblCustomerEmail, 0, 3);
        customerPane.add(txtCustomerEmail, 1, 3);
        customerPane.add(lblCustomerAddress, 0, 4);
        customerPane.add(txtCustomerAddress, 1, 4);
        customerPane.add(btnCreateCustomer, 0, 5);

        customerPane.setHgap(10);
        customerPane.setVgap(10);

        tab2.setContent(customerPane);
        tbPane.getTabs().add(tab2);
        tab2.setClosable(false);

        btnCreateCustomer.setOnAction(e -> {
            try {
                customerData.add(new Customer(txtCustomerName.getText(), txtCustomerPhone.getText(), txtCustomerAddress.getText(), txtCustomerEmail.getText()));

                Alert userPrompt = new Alert(Alert.AlertType.CONFIRMATION, txtCustomerName.getText() + " has been created!", ButtonType.CLOSE);
                userPrompt.show();

                txtCustomerName.clear();
                txtCustomerPhone.clear();
                txtCustomerEmail.clear();
                txtCustomerAddress.clear();

                String sqlQuery = "";
                Customer tempRef = customerData.get(customerData.size() - 1);
                sqlQuery += "insert into javauser.CUSTOMER (customerid, customername, customerphone, customeraddress, customeremail) values (";
                sqlQuery += "'" + ((Customer) tempRef).getCustomerID() + "',";
                sqlQuery += "'" + tempRef.getCustomerName() + "',";
                sqlQuery += "'" + tempRef.getCustomerPhoneNumber() + "',";
                sqlQuery += "'" + tempRef.getCustomerAddress() + "',";
                sqlQuery += "'" + tempRef.getCustomerEmail() + "')";
                sendDBCommand(sqlQuery);
            } catch (IndexOutOfBoundsException ex) {
                Alert userPrompt = new Alert(Alert.AlertType.ERROR, "Please fill out completely!", ButtonType.CLOSE);
                userPrompt.show();
            }
        });

        ////////////////////////////////////////////////////////////////////////
        ///////////////////////////////PRODUCT TAB//////////////////////////////
        productPane.setAlignment(Pos.CENTER);
        productPane.add(lblProductInformation, 0, 0);
        lblProductInformation.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.ITALIC,
                20));
        lblProductInformation.setTextAlignment(TextAlignment.CENTER);
        productPane.add(lblProductName, 0, 1);
        productPane.add(txtProductName, 1, 1);
        productPane.add(lblProductDescription, 0, 2);
        productPane.add(txtProductDescription, 2, 2);
        productPane.add(lblProductPrice, 0, 3);
        productPane.add(txtProductPrice, 1, 3);
        productPane.add(btnCreateProduct, 0, 5);

        productPane.setHgap(10);
        productPane.setVgap(10);

        tab3.setContent(productPane);
        tbPane.getTabs().add(tab3);
        tab3.setClosable(false);

        btnCreateProduct.setOnAction(e -> {
            try {
                productData.add(new Product(txtProductName.getText(), Double.valueOf(txtProductPrice.getText()), txtProductDescription.getText()));

                Alert userPrompt = new Alert(Alert.AlertType.CONFIRMATION, txtProductName.getText() + " has been created!", ButtonType.CLOSE);
                userPrompt.show();

                txtProductName.clear();
                txtProductDescription.clear();
                txtProductPrice.clear();

                String sqlQuery = "";
                Product tempRef = productData.get(productData.size() - 1);
                sqlQuery += "insert into javauser.PRODUCT (productid, productname, productdescription, productprice) values (";
                sqlQuery += "'" + ((Product) tempRef).getProductID() + "',";
                sqlQuery += "'" + tempRef.getProductName() + "',";
                sqlQuery += "'" + tempRef.getProductDescription() + "',";
                sqlQuery += "'" + tempRef.getProductPrice() + "')";
                sendDBCommand(sqlQuery);
            } catch (IndexOutOfBoundsException ex) {
                Alert userPrompt = new Alert(Alert.AlertType.ERROR, "Please fill out completely!", ButtonType.CLOSE);
                userPrompt.show();
            } catch (NumberFormatException ex) {
                Alert userPrompt = new Alert(Alert.AlertType.ERROR, "Please enter the correct data!", ButtonType.CLOSE);
                userPrompt.show();
            }
        });

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////SALESPERSON TAB/////////////////////////////////
        salesPersonPane.setAlignment(Pos.CENTER);
        salesPersonPane.add(lblSalesPersonInformation, 0, 0);
        lblSalesPersonInformation.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.ITALIC,
                20));
        lblSalesPersonInformation.setTextAlignment(TextAlignment.CENTER);
        salesPersonPane.add(lblSalesPersonName, 0, 1);
        salesPersonPane.add(txtSalesPersonName, 1, 1);
        salesPersonPane.add(lblSalesPersonPhone, 0, 2);
        salesPersonPane.add(txtSalesPersonPhone, 1, 2);
        salesPersonPane.add(lblSalesPersonEmail, 0, 3);
        salesPersonPane.add(txtSalesPersonEmail, 1, 3);
        salesPersonPane.add(btnCreateSalesPerson, 0, 5);

        txtSalesPersonPhone.setText("( )xxx-xxx");
        salesPersonPane.setHgap(10);
        salesPersonPane.setVgap(10);

        tab4.setContent(salesPersonPane);
        tbPane.getTabs().add(tab4);
        tab4.setClosable(false);

        btnCreateSalesPerson.setOnAction(e -> {
            try {
                salesPersonData.add(new SalesPerson(txtSalesPersonName.getText(), txtSalesPersonPhone.getText(),
                        txtSalesPersonEmail.getText()));

                Alert userPrompt = new Alert(Alert.AlertType.CONFIRMATION, txtSalesPersonName.getText() + " has been created!", ButtonType.CLOSE);
                userPrompt.show();

                txtSalesPersonName.clear();
                txtSalesPersonPhone.clear();
                txtSalesPersonEmail.clear();

                String sqlQuery = "";
                SalesPerson tempRef = salesPersonData.get(salesPersonData.size() - 1);
                sqlQuery += "insert into javauser.SALESPERSON (salespersonid, salespersonname, salespersonphonenumber, salespersonemail) values (";
                sqlQuery += "'" + ((SalesPerson) tempRef).salesPersonID + "',";
                sqlQuery += "'" + tempRef.getSalesPersonName() + "',";
                sqlQuery += "'" + tempRef.getSalesPersonPhoneNumber() + "',";
                sqlQuery += "'" + tempRef.getSalesPersonEmail() + "')";
                sendDBCommand(sqlQuery);
            } catch (IndexOutOfBoundsException ex) {
                Alert userPrompt = new Alert(Alert.AlertType.ERROR, "Please fill out completely!", ButtonType.CLOSE);
                userPrompt.show();
            }
        });

        //////////////////////////////SERVICE TAB////////////////////////////////
        servicePane.setAlignment(Pos.CENTER);
        servicePane.add(lblServiceInformation, 0, 0);
        lblServiceInformation.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.ITALIC,
                20));
        lblServiceInformation.setTextAlignment(TextAlignment.CENTER);
        servicePane.add(lblServiceName, 0, 1);
        servicePane.add(txtServiceName, 1, 1);
        servicePane.add(lblServiceLevel, 0, 2);
        servicePane.add(txtProductDescription, 1, 2);
        servicePane.add(lblServicePrice, 0, 3);
        servicePane.add(txtServicePrice, 1, 3);
        servicePane.add(lblAssignedTechnician, 0, 4);
        servicePane.add(txtAssignedTechnician, 1, 4);
        servicePane.add(btnCreateService, 0, 5);

        servicePane.setHgap(10);
        servicePane.setVgap(10);

        tab5.setContent(servicePane);
        tbPane.getTabs().add(tab5);
        tab5.setClosable(false);

        btnCreateService.setOnAction(e -> {
            try {
                //serviceData.add(new Service();

                txtProductName.clear();
                txtProductDescription.clear();
                txtProductPrice.clear();

                String sqlQuery = "";
                Product tempRef = productData.get(productData.size() - 1);
                sqlQuery += "insert into javauser.PRODUCT (productid, productname, productdescription, productprice) values (";
                sqlQuery += "'" + ((Product) tempRef).getProductID() + "',";
                sqlQuery += "'" + tempRef.getProductName() + "',";
                sqlQuery += "'" + tempRef.getProductDescription() + "',";
                sqlQuery += "'" + tempRef.getProductPrice() + "')";
                sendDBCommand(sqlQuery);
            } catch (IndexOutOfBoundsException ex) {
                Alert userPrompt = new Alert(Alert.AlertType.ERROR, "Please fill out completely!", ButtonType.CLOSE);
                userPrompt.show();
            }
        });

        ////////////////////////////////////////////////////////////////////////
        //////////////////////////////STORE TAB/////////////////////////////////
        storePane.setAlignment(Pos.CENTER);
        storePane.add(lblStoreInformation, 0, 0);
        lblStoreInformation.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.ITALIC,
                20));
        lblStoreInformation.setTextAlignment(TextAlignment.CENTER);
        storePane.add(lblStoreName, 0, 1);
        storePane.add(txtStoreName, 1, 1);
        storePane.add(lblStoreLocation, 0, 2);
        storePane.add(txtStoreLocation, 1, 2);
        storePane.add(lblStoreAddress, 0, 3);
        storePane.add(txtStoreAddress, 1, 3);
        storePane.add(lblStorePhoneNumber, 0, 4);
        storePane.add(txtStorePhoneNumber, 1, 4);
        storePane.add(btnCreateStore, 0, 5);

        storePane.setHgap(10);
        storePane.setVgap(10);

        tab6.setContent(storePane);
        tbPane.getTabs().add(tab6);
        tab6.setClosable(false);

        btnCreateStore.setOnAction(e -> {
            try {
                storeData.add(new Store(txtStoreName.getText(), txtStoreLocation.getText(),
                        txtStorePhoneNumber.getText(), txtStoreAddress.getText()));

                Alert userPrompt = new Alert(Alert.AlertType.CONFIRMATION, txtStoreName.getText() + " has been created!", ButtonType.CLOSE);
                userPrompt.show();

                txtStoreName.clear();
                txtStoreLocation.clear();
                txtStoreAddress.clear();
                txtStorePhoneNumber.clear();

                String sqlQuery = "";
                Store tempRef = storeData.get(storeData.size() - 1);
                sqlQuery += "insert into javauser.STORE (storeid, storename, storelocation, storeaddress, storephonenumber) values (";
                sqlQuery += "'" + ((Store) tempRef).getStoreID() + "',";
                sqlQuery += "'" + tempRef.getStoreName() + "',";
                sqlQuery += "'" + tempRef.getStoreLocation() + "',";
                sqlQuery += "'" + tempRef.getStoreAddress() + "',";
                sqlQuery += "'" + tempRef.getStorePhoneNumber() + "')";
                sendDBCommand(sqlQuery);
            } catch (IndexOutOfBoundsException ex) {
                Alert userPrompt = new Alert(Alert.AlertType.ERROR, "Please fill out completely!", ButtonType.CLOSE);
                userPrompt.show();
            }
        });

        ////////////////////////////////////////////////////////////////////////
        //////////////////////////////SUPPLIER TAB//////////////////////////////
        supplierPane.setAlignment(Pos.CENTER);
        supplierPane.add(lblSupplierInformation, 0, 0);
        lblSupplierInformation.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.ITALIC,
                20));
        lblSupplierInformation.setTextAlignment(TextAlignment.CENTER);
        supplierPane.add(lblSupplierName, 0, 1);
        supplierPane.add(txtSupplierName, 1, 1);
        supplierPane.add(lblSupplierAddress, 0, 2);
        supplierPane.add(txtSupplierAddress, 1, 2);
        supplierPane.add(lblSupplierPhoneNumber, 0, 3);
        supplierPane.add(txtSupplierPhoneNumber, 1, 3);
        supplierPane.add(lblSupplierEmail, 0, 4);
        supplierPane.add(txtSupplierEmail, 1, 4);
        supplierPane.add(btnCreateSupplier, 0, 5);

        supplierPane.setHgap(10);
        supplierPane.setVgap(10);

        tab7.setContent(supplierPane);
        tbPane.getTabs().add(tab7);
        tab7.setClosable(false);

        btnCreateSupplier.setOnAction(e -> {
            try {
                supplierData.add(new Supplier(txtSupplierName.getText(), txtSupplierAddress.getText(),
                        txtSupplierPhoneNumber.getText(), txtSupplierEmail.getText()));

                Alert userPrompt = new Alert(Alert.AlertType.CONFIRMATION, txtSupplierName.getText() + " has been created!", ButtonType.CLOSE);
                userPrompt.show();

                txtSupplierName.clear();
                txtSupplierAddress.clear();
                txtSupplierPhoneNumber.clear();
                txtSupplierEmail.clear();

                String sqlQuery = "";
                Supplier tempRef = supplierData.get(supplierData.size() - 1);
                sqlQuery += "insert into javauser.SUPPLIER (supplierid, suppliername, supplieraddress, "
                        + "supplierphonenumber, supplieremail) values (";
                sqlQuery += "'" + ((Supplier) tempRef).getSupplierID() + "',";
                sqlQuery += "'" + tempRef.getSupplierName() + "',";
                sqlQuery += "'" + tempRef.getSupplierAddress() + "',";
                sqlQuery += "'" + tempRef.getSupplierPhoneNumber() + "',";
                sqlQuery += "'" + tempRef.getSupplierEmail() + "')";
                sendDBCommand(sqlQuery);
            } catch (IndexOutOfBoundsException ex) {
                Alert userPrompt = new Alert(Alert.AlertType.ERROR, "Please fill out completely!", ButtonType.CLOSE);
                userPrompt.show();
            }
        });

        ////////////////////////////////////////////////////////////////////////
        ///////////////////////////TECHNICIAN TAB///////////////////////////////
        technicianPane.setAlignment(Pos.CENTER);
        technicianPane.add(lblTechnicianInformation, 0, 0);
        lblTechnicianInformation.setFont(Font.font("Impact", FontWeight.LIGHT, FontPosture.ITALIC,
                20));
        lblTechnicianInformation.setTextAlignment(TextAlignment.CENTER);
        technicianPane.add(lblTechnicianName, 0, 1);
        technicianPane.add(txtTechnicianName, 1, 1);
        technicianPane.add(lblTechnicianStore, 0, 2);
        technicianPane.add(txtTechnicianStore, 1, 2);
        technicianPane.add(lblTechnicianPhoneNumber, 0, 3);
        technicianPane.add(txtTechnicianPhoneNumber, 1, 3);
        technicianPane.add(lblTechnicianEmail, 0, 4);
        technicianPane.add(txtTechnicianEmail, 1, 4);
        technicianPane.add(btnCreateTechnician, 0, 5);

        technicianPane.setHgap(10);
        technicianPane.setVgap(10);

        tab8.setContent(technicianPane);
        tbPane.getTabs().add(tab8);
        tab8.setClosable(false);

        btnCreateTechnician.setOnAction(e -> {
            try {
                //serviceData.add(new Service();

                txtProductName.clear();
                txtProductDescription.clear();
                txtProductPrice.clear();

                String sqlQuery = "";
                Product tempRef = productData.get(productData.size() - 1);
                sqlQuery += "insert into javauser.PRODUCT (productid, productname, productdescription, productprice) values (";
                sqlQuery += "'" + ((Product) tempRef).getProductID() + "',";
                sqlQuery += "'" + tempRef.getProductName() + "',";
                sqlQuery += "'" + tempRef.getProductDescription() + "',";
                sqlQuery += "'" + tempRef.getProductPrice() + "')";
                sendDBCommand(sqlQuery);
            } catch (IndexOutOfBoundsException ex) {
                Alert userPrompt = new Alert(Alert.AlertType.ERROR, "Please fill out completely!", ButtonType.CLOSE);
                userPrompt.show();
            }
        });

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////MENU BAR OPTIONS////////////////////////////////
        Menu menuDisplayInventory = new Menu("Tools");
        Menu menuDescribe = new Menu("View");
        Menu menuClose = new Menu("Close");

        menuDisplayInventory.getItems().add(new MenuItem("Total Inventory"));
        menuDescribe.getItems().add(new MenuItem("Display Customers"));
        menuDescribe.getItems().add(new MenuItem("Display Store Employees"));
        menuDescribe.getItems().add(new MenuItem("Display Technicians"));
        menuClose.getItems().add(new MenuItem("Logout"));

        mnuBar.getMenus().addAll(menuDisplayInventory, menuDescribe, menuClose);

        menuDisplayInventory.getItems().get(0).setOnAction(e -> {

        });

        menuDescribe.getItems().get(0).setOnAction(e -> {

        });

        tbPane.minHeightProperty().bind(primaryScene.heightProperty());

        // Obersvable Listener
        primaryScene.widthProperty().addListener(ov -> {
            overallPane.setMinWidth(primaryScene.getWidth() - 20);
            mnuBar.setMinWidth(primaryScene.getWidth() - 20);
            tbPane.setMinWidth(primaryScene.getWidth() - 20);
        });
        ////////////////////////////////////////////////////////////////////////
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void sendDBCommand(String sqlQuery) {
        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser"; // Change to YOUR Oracle username
        String userPASS = "javapass"; // Change to YOUR Oracle password
        OracleDataSource ds;

        // Clear Box Testing - Print each query to check SQL syntax
        //  sent to this method.
        // You can comment this line out when your program is finished
        System.out.println(sqlQuery);

        // Lets try to connect
        try {
            // instantiate a new data source object
            ds = new OracleDataSource();
            // Where is the database located? Web? Local?
            ds.setURL(URL);
            // Send the user/pass and get an open connection.
            dbConn = ds.getConnection(userID, userPASS);
            // When we get results
            //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
            //   will see our resultset update in real time.
            //  -CONCUR_READ_ONLY means that we cannot accidentally change the
            //   data in our database by using the .update____() methods of
            //   the ResultSet class - TableView controls are impacted by
            //   this setting as well.
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // We send the query to the DB. A ResultSet object is instantiated
            //  and we are returned a reference to it, that we point to from
            // dbResults.
            // Because we declared dbResults at the datafield level
            // we can see the results from anywhere in our Class.
            dbResults = commStmt.executeQuery(sqlQuery); // Sends the Query to the DB
            // The results are stored in a ResultSet structure object
            // pointed to by the reference variable dbResults
            // Because we declared this variable globally above, we can use
            // the results in any method in the class.
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}
