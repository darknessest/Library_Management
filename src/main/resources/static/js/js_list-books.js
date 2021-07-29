
    function open_details()
    {
        let card_details = document.getElementById("details_card");
        card_details.style.display = "block";
        card_details.style.opacity = 1;

        let card= document.getElementById("container");

        card.style.opacity = 0.3;

        console.log("nmsl");
    }

    function close_details()
    {
        let card_details = document.getElementById("details_card");
        card_details.style.display = "none";
        card_details.style.opacity = 0;

        let card= document.getElementById("container");

        card.style.opacity = 1;
    }

    function getCurDate()
    {
        // let x = $("#start_date");
        // x.val() = new Date();

        let now = new Date();

        var day = ("0" + now.getDate()).slice(-2);
        var month = ("0" + (now.getMonth() + 1)).slice(-2);
        var year = now.getFullYear();
        var date = year+"-"+(month)+"-"+(day);

        let y = document.getElementById("start_date");
        y.value = date

        console.log(date);

    }

    function open_borrow()
    {
        let card = document.getElementById("borrow_card");
        card.style.display = "block";
        card.style.opacity = 1;

        getCurDate()

        let card2= document.getElementById("container");

        card2.style.opacity = 0.3;
    }

    function close_borrow()
    {
        let card = document.getElementById("borrow_card");
        card.style.display = "none";
        card.style.opacity = 0;

        let card2= document.getElementById("container");

        card2.style.opacity = 1;
    }

    function open_add()
    {
        let card = document.getElementById("add_card");
        card.style.display = "block";
        card.style.opacity = 1;

        let card2= document.getElementById("container");

        card2.style.opacity = 0.3;
    }

    function close_add()
    {
        let card = document.getElementById("add_card");
        card.style.display = "flex";
        card.style.opacity = 0;

        let card2= document.getElementById("container");

        card2.style.opacity = 1;
    }

    function isDateIllegal()
    {
        let d1 = $("#start_date");
        let d2 = $("#end_date");

        var tag = true;


    }