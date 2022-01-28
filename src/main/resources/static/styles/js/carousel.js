$(document).ready(function() {
    // create arrays of images to be displayed in each carousel for each thumbnails.
    // the array name is exactly the same as thumbnail id
    var thumb1 = new Array("book2.jpg","book3.jpg","book4.jpg","book5.jpg");
    var thumb2 = new Array("book3.jpg","book4.jpg","book5.jpg","book2.jpg");
    var thumb3 = new Array("book4.jpg","book5.jpg","book2.jpg","book3.jpg");
    var thumb4 = new Array("book5.jpg","book4.jpg","book3.jpg","book2.jpg");

    var $carousel = $('#carousel-example-generic .carousel-inner');
    var $carouselInd =  $('#carousel-example-generic .carousel-indicators');

    $( ".thumbnail" ).click(function() {

        var numberOfSlides = $('.item').length;

        if(numberOfSlides >0) {
            // remove all items from the carousel before adding the new ones to it.
            $carousel.empty();
            //$carouselInd.empty();

        }

        var m = this.id;
        m = eval(m);

        //alert(m.length);

        for(var i=0 ; i< m.length ; i++) {
            var j= i+1;
            $('<div class="item"><img src="images/'+m[i]+'"><div class="carousel-caption"></div>   </div>').appendTo('.carousel-inner');
            $('<li data-target="#carousel-example-generic" data-slide-to="'+i+'"><img src="http://placehold.it/100x50&text=slide'+j+'" alt="" /></li>').appendTo('.carousel-indicators');

        }
        $('.item').first().addClass('active');
        $('.carousel-indicators > li').first().addClass('active');
        $('#carousel-example-generic').carousel();

    });

});
