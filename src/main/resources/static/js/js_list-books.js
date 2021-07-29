let cur_id;

function open_details(
    name, type, serialName,
    author, publisher, price,
    leftInStock,
    isbn, description
) {
    let card_details = document.getElementById("details_card");
    card_details.style.display = "block";
    card_details.style.opacity = 1;

    let card = document.getElementById("container");

    // card.style.opacity = 0.3;

    $("#info_bookname").attr("value", name);
    $("#info_categories").attr("value", type);
    $("#info_serialName").attr("value", serialName);
    $("#info_author").attr("value", author);
    $("#info_publisher").attr("value", publisher);
    $("#info_price").attr("value", price);
    $("#info_leftInStock").attr("value", leftInStock);
    $("#info_ibsn").attr("value", isbn);
    $("#info_description").attr("value", description);

    $("#info_description_label").attr("value", description);
}

function close_details() {
    let card_details = document.getElementById("details_card");
    card_details.style.display = "none";
    card_details.style.opacity = 0;

    let card = document.getElementById("container");

    card.style.opacity = 1;
}

function getCurDate() {
    // let x = $("#start_date");
    // x.val() = new Date();

    let now = new Date();

    let day = ("0" + now.getDate()).slice(-2);
    let month = ("0" + (now.getMonth() + 1)).slice(-2);
    let year = now.getFullYear();
    let date = year + "-" + (month) + "-" + (day);

    let y = document.getElementById("start_date");
    y.value = date

    console.log(date);

}

function open_borrow(id) {
    let card = document.getElementById("borrow_card");
    card.style.display = "block";
    card.style.opacity = 1;

    getCurDate()

    let card2 = document.getElementById("container");

    cur_id = id;

    card2.style.opacity = 0.3;
}

function request_borrow() {
    let start_date = document.getElementById("start_date").value;
    let end_date = document.getElementById("end_date").value;
    console.log(start_date)
    console.log(end_date)
    $.ajax({
        url: "/book/borrow/" + cur_id, type: "POST", data: {"startDate": start_date, "endDate": end_date},
        success: function (result) {
            new_page = result;
            // window.location.href = "http://localhost:8081/";
            close_borrow();

            console.log(result);
        },
        error: function () {
            //显示错误
            console.log("DATA ERROR");
        }
    })
}

function request_return() {
    $.ajax({
        url: "/book/return/" + cur_id, type: "POST", data: {},
        success: function (result) {
            new_page = result;
            // window.location.href = "http://localhost:8081/";
            close_borrow();

            console.log(result);
        },
        error: function () {
            //显示错误
            console.log("DATA ERROR");
        }
    })
}

function close_borrow() {
    let card = document.getElementById("borrow_card");
    card.style.display = "none";
    card.style.opacity = 0;

    let card2 = document.getElementById("container");

    card2.style.opacity = 1;
}

function open_add() {
    let card = document.getElementById("add_card");
    card.style.display = "block";
    card.style.opacity = 1;

    let card2 = document.getElementById("container");

    card2.style.opacity = 0.3;
}

function close_add() {
    let card = document.getElementById("add_card");
    card.style.display = "flex";
    card.style.opacity = 0;

    let card2 = document.getElementById("container");

    card2.style.opacity = 1;
}

function isDateIllegal() {
    let d1 = $("#start_date");
    let d2 = $("#end_date");

    var tag = true;


}