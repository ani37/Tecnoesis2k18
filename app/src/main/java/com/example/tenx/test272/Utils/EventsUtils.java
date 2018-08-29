package com.example.tenx.test272.Utils;

import com.example.tenx.test272.ListItems.EventItem;
import com.example.tenx.test272.ListItems.HeaderItem;
import com.example.tenx.test272.ListItems.ListItem;
import com.example.tenx.test272.R;
import com.example.tenx.test272.Utils.Models.Event;
import com.example.tenx.test272.Utils.Models.Workshop;

import java.util.ArrayList;
import java.util.List;

public class EventsUtils {


    public static List<ListItem> getData(){
        List<ListItem> list = new ArrayList<>();
        list.add(new HeaderItem("28 October 2018"));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png"));
        list.add(new EventItem("event2", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png"));
        list.add(new EventItem("event3", "http://tecnoesis.in/vr/images/Modules/ASME.png"));
        list.add(new EventItem("event4", "http://tecnoesis.in/vr/images/Modules/robotron.png"));
        list.add(new EventItem("event5", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCx-XNTe4EaOBnQgfsDDjHD-feNS-qDo3lX134E3SRpA8hj_NO"));
        list.add(new EventItem("event6", "http://tecnoesis.in/vr/images/Modules/robotron.png"));
        list.add(new HeaderItem("29 October 2018"));
        list.add(new EventItem("event6", "https://pbs.twimg.com/media/DMZ5H8jU8AAAsU-.jpg"));
        list.add(new EventItem("event7", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2o4THGSmZC4IDB3OZWNcQgdIo2lQQ1uOnvF2PEqcmFvjOPRT5"));
        list.add(new EventItem("event8", "http://tecnoesis.in/vr/images/Modules/ASME.png"));
        list.add(new EventItem("event9", "https://pbs.twimg.com/media/DLeVx-ZUIAAo6Ad.jpg"));
        list.add(new EventItem("event10", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png"));
        list.add(new EventItem("event11", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png"));
        return list;

    }
    public static String home_imageUrl[] = {"http://tecnoesis.in/vr/images/Modules/schoolgenius.png","https://pbs.twimg.com/media/DMZ5H8jU8AAAsU-.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2o4THGSmZC4IDB3OZWNcQgdIo2lQQ1uOnvF2PEqcmFvjOPRT5",
            "http://tecnoesis.in/vr/images/Modules/ASME.png",
            "http://tecnoesis.in/vr/images/Modules/robotron.png",
            "https://pbs.twimg.com/media/DLeVx-ZUIAAo6Ad.jpg",
            "http://tecnoesis.in/vr/images/Modules/schoolgenius.png","https://pbs.twimg.com/media/DMZ5H8jU8AAAsU-.jpg"};


    public static int[] modules_list = {R.drawable.robotron, R.drawable.conferenza, R.drawable.spark};

    public static List<Workshop> getWorkshopList(){
        List<Workshop> list = new ArrayList<>();
        list.add(new Workshop("Learn new skills with us!", "http://www.tecnoesis.in",R.drawable.works_android ));
        list.add(new Workshop("Learn new skills with us!", "http://www.tecnoesis.in",R.drawable.works_arduino ));
        list.add(new Workshop("Learn new skills with us!", "http://www.tecnoesis.in", R.drawable.works_web));
        list.add(new Workshop("Learn new skills with us!", "http://www.tecnoesis.in", R.drawable.works_java));
        list.add(new Workshop("Learn new skills with us!", "http://www.tecnoesis.in", R.drawable.works_hack));
        return list;
    }

    public static List<Event> getEventsList(){
        List<Event> list = new ArrayList<>();
        list.add(new Event(R.drawable.event_shootout, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.event_shootout, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.event_shootout, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.event_shootout, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.event_shootout, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.event_shootout, "http://www.tecnoesis.in",""));

        return list;
    }

    public static List<Event> getSparkEventList(){
        List<Event> list = new ArrayList<>();
        list.add(new Event(R.drawable.spark_1, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.spark_2_nalayak, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.spark_3, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.spark, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.spark_5, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.spark_4, "http://www.tecnoesis.in",""));
        return list;
    }



}
