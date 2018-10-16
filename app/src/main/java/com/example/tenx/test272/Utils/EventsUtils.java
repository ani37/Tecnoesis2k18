package com.example.tenx.test272.Utils;

import android.content.res.Resources;

import com.example.tenx.test272.ListItems.EventItem;
import com.example.tenx.test272.ListItems.HeaderItem;
import com.example.tenx.test272.ListItems.ListItem;
import com.example.tenx.test272.R;
import com.example.tenx.test272.Utils.Models.Event;
import com.example.tenx.test272.Utils.Models.ModuleEvent;
import com.example.tenx.test272.Utils.Models.Workshop;

import java.util.ArrayList;
import java.util.List;

public class EventsUtils {


    public static List<ListItem> getData(){
        List<ListItem> list = new ArrayList<>();
        list.add(new HeaderItem("28 October 2018"));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.g9));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.r1));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.g11));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.r2));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.g13));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.g14));
        list.add(new HeaderItem("29 October 2018"));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.b1));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.b2));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.b3));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.b4));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.b5));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.b6));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.b7));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.b8));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.soon));
        list.add(new EventItem("event1", "http://tecnoesis.in/vr/images/Modules/schoolgenius.png", "Updating soon!", R.drawable.soon));

        return list;

    }
    public static String home_imageUrl[] = {"http://tecnoesis.in/vr/images/Modules/schoolgenius.png","https://pbs.twimg.com/media/DMZ5H8jU8AAAsU-.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2o4THGSmZC4IDB3OZWNcQgdIo2lQQ1uOnvF2PEqcmFvjOPRT5",
            "http://tecnoesis.in/vr/images/Modules/ASME.png",
            "http://tecnoesis.in/vr/images/Modules/robotron.png",
            "https://pbs.twimg.com/media/DLeVx-ZUIAAo6Ad.jpg",
            "http://tecnoesis.in/vr/images/Modules/schoolgenius.png","https://pbs.twimg.com/media/DMZ5H8jU8AAAsU-.jpg"};


    public static int[] modules_list = {R.drawable.robotron, R.drawable.conferenza, R.drawable.spark};
    public static List<String> getModulesNames(){
        List<String> list = new ArrayList<>();
        list.add("ROBOTRON");
        list.add("SHOWCASE");
        list.add("AMAZERS");
        list.add("CONFERENZA");
        list.add("CYBERWARP");
        list.add("V-WARZ");
        list.add("SMARTCITY");
        list.add("MYNDSNARE");
        list.add("EMPRESAARIO");
        list.add("SCHOOL GENIUS");
        list.add("ASME");
        return list;
    }

    public static List<Workshop> getWorkshopList(){
        List<Workshop> list = new ArrayList<>();
        list.add(new Workshop("Updating Soon!", "http://www.tecnoesis.in",R.drawable.soon ));
        return list;
    }

    public static List<Event> getEventsList(){
        List<Event> list = new ArrayList<>();
        list.add(new Event(R.drawable.nits_hacks, "http://www.tecnoesis.in",""));
        return list;
    }

    public static List<Event> getSparkEventList(){
        List<Event> list = new ArrayList<>();
        list.add(new Event(R.drawable.s1, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.s2, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.s3, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.s4, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.s5, "http://www.tecnoesis.in",""));
        list.add(new Event(R.drawable.s6, "http://www.tecnoesis.in",""));
        return list;
    }

    public static List<ModuleEvent> getRobotronEvents(){
        List<ModuleEvent> list = new ArrayList<>();
        list.add(new ModuleEvent("ROBOWARS","The flagship event of any Robotics competition, Robowars, sees the age old entertainment of two robots battling it out in the center to be the last one standing. This presents a chance for the challenger to show their robotic acumen, intellect, and fighter spirit. Teams are encouraged to equip their bots with high torqued industrial motors, protective armour sheets, and well designed weapons to take down the enemy bot. ",
                "Design and construct a robot capable of fighting another in a one on one tournament. This event aims to test your Robot against another in a field of combat where brute strength and cat-like reflexes hold the key to success. ","Shivam Verma - 7355466937", "Debasish Kashyap- 9577499957","http://tecnoesis.in/module/rw.pdf", "https://goo.gl/forms/Om55m3w69hFCn3HW2", "Prize Money : Rs 25000/-"));
        list.add(new ModuleEvent("ROBOSOCCER 4.0",
                "Do you get notifications for both football matches and technical advancements? Do you idolize both Sir Alex Ferguson and Elon Musk? Do you jump the same height when Messi/Ronaldo scores and when your robot follows command? And do you despise this planet because no one has been able to come up with a perfect blend of both football and tech?\n" +
                        "Well fear not! The time has come to combine Passion and Profession. So suit up, pull up your socks, (eat that throat medicine) and get ready to shout at the top of your voice!\n" +
                        "Find out if you have what it takes, to Roboscore!",
                "1.Teams must build two robots, designed and engineered in the sense that one of them will kick the ball while the other will defend your goalpost. \n 2. Team should consist of a maximum of 5 members.\n" +
                        "     \"Let the battle begin\"\n" +
                        "    \"Que la bataille commence","Bolisetti Dheeraj - 7024484438", "Sandeep Bolla- 9100700125 ",  "http://tecnoesis.in/module/rs.pdf", "https://goo.gl/forms/m2yyjF8lIGtPNctm2",
                "Prize Money : Rs 20000/-"));
        list.add(new ModuleEvent("TERRAIN TREADER","Innovation is an adventurous process, and so Tecnoesis'18 presents Terrain Trader, an event where your creative intelligence is put to the test.This encourages students to design such a robot that uses innovative solutions to the challenges faced on the arena. Driving over rough terrain will be difficult and the solution to the problems will be highly interdisciplinary. ",
                "To construct a manual bot capable of grabbing, lifting and pushing blocks as well as crossing different kinds of adverse terrains ", "Rohit Lohia - 7035691091", "Vijay Gupta- 7413899928 ",
              "http://tecnoesis.in/module/terrain.pdf",  "https://docs.google.com/forms/d/e/1FAIpQLScVokzWvgIrcGQ2yYWIzvOawAtyfInpBlCxEXn1RK6wrr8RoQ/viewform?usp=pp_url",  "Prize Money : Rs 20000/-"));
        list.add(new ModuleEvent("SUMOWARS", "From the WALL-Es to the Terminators to Sophia, robots have instilled fascination in us all at one point of our life or the other. Sumo Wars gives you the opportunity to live out your fascination and devise your own fully functional autonomous bots.\n" +
                "Sumo fight is an ancient form of art practiced in eastern countries for centuries as a sport. It involves a combat between the contestants in which they try to overthrow the opponent out of arena. SUMO WARS is inspired by the same,with the exception that bots try to overrun the other bots using their swiftness and robustness. You will be needed to build your own autonomous bots and cement your name as the king of the ring. ",
                "In this autonomous robotic event, the competing team has to make a bot capable of searching and pushing opponent bot out of the arena, all the whilekeeping itself inside the arena.",
               "Makarand - 9767730714",  "Ankit- 8875825910 ", "http://tecnoesis.in/module/sumo.pdf","https://docs.google.com/forms/d/1pTd5DRS66Kokyw_SGRT1BPMMpaJkZOJzsTFyqSACBvs/edit?usp=drivesdk",
                "Prize Money : Rs 20000/-"));
        list.add(new ModuleEvent("ROBOBUILD","If the answer to the former questions are yes, then fellas! You’ve stepped your bot in the right arena. This tecnoesis we bring to you, an event which gives you an arena to both, construct and destruct at the same time. We give your motor skills a real challenge as the bots are fully mechanized and the control tactics are in your hands.\n" +
                "\n" +
                "It's not only the race with time, but also a race with your opponent to see who has smartness with strength. Burn the arena with action to see who builds the best bot to build the best tower with the timer saying tick tock tick tock......\n 'Build your bot, it will build for you'.", "Your team has to build two bots (assistive and builder namely) where one constructs and the other helps you collect blocks, defend your tower, and attack the opponent’s tower to bring ’em down.\n" +
                "Now as your bot is restricted to enter the opponent’s boundary, you will have to add a weapon on top of your assistive bot to bring the tower down. Also, the mighty sphere is a cherry over the cake with a nostalgic tinge to Harry potter’s famous game Quidditch. To know more about the game, click on the Description given below. ",
                "Saket Suman - 7033244882", "Tanmay Sardar- 8305035560 ", "http://tecnoesis.in/module/build.pdf", "https://goo.gl/forms/36cobeks1HOMaRhD2", "Prize Money : Rs 20000/-"));
        list.add(new ModuleEvent("ROBOART","Why not to make your life easier when you have the power of Robotics in hand? Are mainstream event bots so much cliche for you guys and are you up for exploring the possibilities of reinvention? If yes then Roboarts is here for you - The Art Of Making Robots. ",
                "The participants will be given 8 hours (4+4) to construct a bot. The bot application is unbounded, so participants are free to use their imagination and may build any kind of bot. The bot will be judged on the basis of its application, not complexity since it is a time bound event. ",
                "Abhinav Kiran - 8210542708", "Rishikesh Sutradhar- 8876959207", "http://tecnoesis.in/module/art.pdf","https://docs.google.com/forms/d/1Nzb0VcaNchXpaAA96jExEqyDRIK_26KcWTuUpNYSH3A/edit",
                "Prize Money : Rs 15000/-"));
        return list;
    }

    public static List<ModuleEvent> getAsmeEvents(){
        List<ModuleEvent> list = new ArrayList<>();
        list.add(new ModuleEvent("1. DRAFT RITZ", "Designing plays an essential role in innovation. The field of designing accounts for majority of private research and development spending and employs a significant percentage of engineers. In order for society to benefit from the latest advances in technology, skilled engineers and novel designing techniques will be required.\n" +
                "\n" +
                "There is a thirst among every engineer for designing, a thirst which is motivated by seeing day to day things ranging from a small pin to huge working machine. This thirst which has resulted for the designing of basic component parts of a machine to the design of highly sophisticated engines. General design competitions have always had a constraint that bounds the imaginative skills of the enthusiasts to create something new or intuitive, so to tackle this ASME NIT Silchar Chapter came up with this competition. It is a competitive event where the design and imaginative skills of the participants will be put to test under the ticking of a clock.", "", "Kshitij Mehrotra - 9634857887", "Dhruv Gupta- 8318734532",
                "http://tecnoesis.in/module/dri.pdf","https://goo.gl/forms/hKHnM8ESGcCQJl9Q2", "" ));
        list.add(new ModuleEvent("2.ROCKETO POLEMOS", "Ever wondered how to make rockets? Here is your chance. This Tecnoesis ASME NIT Silchar Chapter presents to you Rocketo Polemos, an amateur rocketry competition where you will build your own rocket and compete with others. We have always had that little curiosity and desire to build rockets since childhood, this is the time to showcase your hidden talent.\n" +
                "\n" +
                "The competition expects the participants to showcase their innovative ideas and how they can apply their ideas and knowledge in the field of application and design a rocket. A basic knowledge of Chemistry of fuel and oxidizers is expected although it isn’t necessary. Your interest matters not your branch or discipline. Come join us and check whether you have the necessary skills to fly up high in the sky ", "","Karan Chetri - 8471880811",
                "Sohail Sajid Alam- 9706442354", "http://tecnoesis.in/module/rock.pdf","https://goo.gl/forms/sFEiqKlDwBs8YeJA2", ""));
        list.add(new ModuleEvent("3.SAILOR SAFARI", "Are you fond of making paper boats during rainy season and love to compete as to which one goes faster? Then look no further as, this Tecnoesis ASME NIT Silchar Chapter presents to you Sailor Safari. The event comprises of a boat racing competition where you will build your own boat competing against time and other participants (or should we say pirate sailors!!!). Guess what?? There's only one rule, the fastest shall survive. Come join us on this ride and enjoy the thrill on top of a boat and see whether you can weather the storm and battle your way to glory. ", "", "Arnab Roy - 9859772100",
                "Rituraj Choudhury- 8638293104", "http://tecnoesis.in/module/sailor.pdf", "https://goo.gl/forms/Dd72sxHPa6yV8AqH3", ""));

        return list;
    }
    public static List<ModuleEvent> getSmartCityEvents(){
        List<ModuleEvent> list = new ArrayList<>();
        list.add(new ModuleEvent("1.MY CITY MY DREAMS", "What is a Smart City?\n" +
                "\n" +
                "“A Smart City is an urban ecosystem that places emphasis on the use of digital technology, shared knowledge and cohesive processes to underpin citizen benefits in sectors such as mobility, public safety, health and productivity.”\n" +
                "\n" +
                "A Smart City Future\n" +
                "\n" +
                "“Imagine a world where all cities are smart and able to thrive as part of a cohesive effort between municipalities, businesses and citizens. Many cities are now becoming smarter, adopting strategies to address a growing need to improve their ‘liveability’. Here, we explore what efforts need to be taken to improve mobility, public safety, public healthcare and productivity are being confronted as they transition to a smarter, more connected environment.”\n" +
                "\n" +
                "As Albert Einstein said that Imagination is more important than Knowledge since knowledge is limited. Hence this event of \"Smart City\" is all about the upcoming possibilities, stupendous imagination, holistic integrated approach of the participants wherein they can hypothetically make any desired model would help the people going to live in their dream 'Smart City' and this would also help in making this world a better place to live in. ",
                "","Amitabh Dey - 7002509469", "Bainapalli Akash- 9101336249",  "http://tecnoesis.in/module/smartcity.pdf", "https://drive.google.com/open?id=1_l3tPBXNT-VV2B34q606eNX5mkesqAXPtR-WnhtLrSc", ""));
        list.add(new ModuleEvent("2.ARCHINOVA", "This is a event conducted to initiate and encourage the process of innovative thinking in the field of structural designing and search for new ideas to transform our surroundings.\n" +
                "\n" +
                "In this event, the competing team has to prepare a model and give a presentation on it clearly stating its aim, working procedures and advantages.\n" +
                "Now coming to why one should take interest in Archinova :\n" +
                "\n" +
                "    This event allows the participants from various discipline to showcase their structural designing skills and execute their knowledge of science in designing models.\n" +
                "    This event allows the participants from various discipline to showcase their structural designing skills and execute their knowledge of science in designing models.\n" +
                "    If your model is innovative and enough convincing, it will be executed in reality in near future keeping aside the existing prizes for the position holders!!!! Who doesn't want such fame????\n", "",
                "Raushan Raj - 8409827214", "Yash Gupta- 7618229837", "http://tecnoesis.in/module/arch.pdf", "https://docs.google.com/forms/d/e/1FAIpQLSe9iFOWY9fyqfyaPk16nxWBRj_yAfbGr2W-JS8FZfvo4aipeQ/viewform?usp=pp_url", ""));


        return list;
    }

    public static List<ModuleEvent> getEmpressarioEvents(){
        List<ModuleEvent> list = new ArrayList<>();
        list.add(new ModuleEvent("1. If I Were the CEO", "Ever conjectured about a life where you enhance the technicalities of being a CEO ? The hindrances and snags they have to undergo in pursuance of the comprehensive assets of a company. Here is your opportunity to showcase your skills in handling a task if you were a CEO. ",
                " This online event promotes participants to answer the question”If i were the CEO of XYZ company,then how would i have undertaken the company’s tasks differently?What changes would i have brought about for the overall augmentation of the company?”\n", "","","","",""));
        list.add(new ModuleEvent("2. PITCH PLEASE", "Conceiving an idea may be fundamental . But today in a world with a million ideas, without proper knowledge and way of selling your idea, even a brilliant idea would yield no fruit. Here is where the beauty of the term “PITCHING” comes into effect. In Layman’s terms, it means presenting your idea in front of a potential investor, convince him about the viability of your product, clear his doubts and show them the dreams that you have been dreaming to contribute to the world in general by setting up a prospective business from your idea. If you want to master and test your art of persuasion and selling your idea, this event is the ideal place for you to be.",
               "","","", "http://tecnoesis.in/module/empre.pdf", "https://docs.google.com/forms/d/e/1FAIpQLSdAzeHpm5iDN9MfXdBrMnyF1rCTsZZhUJve0-bYnscUXeg9TQ/viewform",
                ""));
        list.add(new ModuleEvent("3.BECH KE DIKHAO","Like all other talents and skills honed over time, selling something is truly an art form that takes practice to improve upon.\n" +
                "\n" +
                "The art of selling anything in today's world requires creativity and should know about the customer's pulse.\n" +
                "\n" +
                "If there is a company that sells similar products or services to yours, you can only make customers buy from you if you have special selling techniques going on.\n" +
                "\n" +
                "E-Cell, NITS brings you the most exciting event \"Bech Ke Dikhao\" under the module of \"Empresario\" in this \"Technoesis\" to test your creativity and spontaneity by selling a bunch of crazy items to the customers ",
                "Here you will be given a random item and you have to convince the judges to buy it. As the saying goes “Item doesn't get sold, emotions and stories does”, so how well can you connect emotions and stories to get your Product sold will be checked. ",
                "", "", "http://tecnoesis.in/module/empre.pdf", "https://docs.google.com/forms/d/e/1FAIpQLScN6ls_Eqzn2aBqFpVuu1Mtnrahd-K0UD5ltaEQW8xjH8ubXA/viewform?usp=sf_link", ""));

       list.add(new ModuleEvent("4.AD-OVATION","In a world where thousands of innovations and billions of ideas occur every single day, do YOU have what it takes to get your idea out to this world?\n" +
               "\n" +
               "Advertising a product to the masses is so much more nuanced than just telling people about it. Ad-Ovation invites you to do exactly that. We tell you what product to promote. Your challenge is to make your very own video advertisement for it as creatively as you can. People vote for your advertisement with Facebook reactions, you inch closer and closer to winning.\n" +
               "\n" +
               "Participate in Ad-Ovation and walk away with exciting prizes and the pride of popularity. Your product will be etched in everyone’s mind and so will you be. ",
               "", "", "","http://tecnoesis.in/module/empre.pdf","https://docs.google.com/document/d/1TfyMAho5SYxBRYl2NOXKQqYWxOQ4YNbvxEZMNtXPX6Y/edit",""));

        return list;
    }

    public static List<ModuleEvent> getSchoolGeniusEvents(){
        List<ModuleEvent> list = new ArrayList<>();
        list.add(new ModuleEvent("1.ROBOTICS WORKSHOP","Robotics is an emerging technology that is changing the world. Are you intrigued by it and want to dig deeper into this technology? Then grab this chance to learn something new about this technology! Just clear the prelims and you are good to go. ",
                "","","","","",""));

        list.add(new ModuleEvent("2.SCIENTIFIC DIG","The vast universe of science has always kept us gazing inamazement . This event aims to uncover the scientific intelligence of students where they need to identify the various phenomena being asked in the question. Questions will be aided by visuals. ",
                "","","","","",""));


        list.add(new ModuleEvent("3.TEENPRENEUR","Ever dreamt of becoming the CEO of a company? Does management amaze you? Then there's no waiting! Teenpreneur is the best platform to kick start your dreams. Come, showcase your inner managerial skills and amuse us! The participants will be given a hypothetical situation for which they will have to provide solution from a CEO’s point of view to resolve the same. ",
                "","","","","",""));

        list.add(new ModuleEvent("4. STARTUP BUZZ","Did you know that 3-4 startups are registered per day in India? This event has been orchestrated in order to familiarise you with this rising vogue in our country. Does entrepreneurship amaze you and inspire you to start a business of your own? Then “Start Up Buzz” is a wonderful chance for you to manifest your ideas. Prepare a presentation consisting of details like working idea, cost, agendas, advertisement, marketing etc. and share it with the audience. "));
        list.add(new ModuleEvent("5. CRIME SCENE INVESTIGATION", "“Crime Scene Investigation” is the ultimate destination to display your crime solving abilities and thus bring out the Sherlock Holmes in you! So get ready for some adventure and don the detective’s hat as we bring to you several tantalizing crime scenes. "));
        list.add(new ModuleEvent("6. ALMANAC OF EVOLUTION", "The world of science and technology is ever growing and never fails to capture our minds. This event is a model making competition where the participants have to come up with innovative ideas and present their models to the judges. Participation may be either individually or in teams. "));
        list.add(new ModuleEvent("7. TASKABET", "A little offbeat, Taskabet is no conventional event! An engaging game where individuals have to perform the assigned tasks, get letters for each accomplished task and make words from them to gain points, Taskabet is sure to enthrall you!\n" +
                "\n" +
                "Students may participate individually or in groups of 3. "));
        list.add(new ModuleEvent("8. XENG", " The ultimate concoction of amusement and learning, Xeng, is back to mesmerise the young quiz lovers all over again. The qualifying teams will have to tackle against one another to clinch the prizes. "));
        list.add(new ModuleEvent("9.WHAT IF?","What if another advanced species existed? What if India never got freedom from British rule? Things would have taken a turn and been something so different!\n" +
                "\n" +
                "Plunge into your time machines, exercise your brain cells and create a whole new scenario from your imagination within a the given time, explaining what would have been different and how. "));
        list.add(new ModuleEvent("10.SPELL BEE","This is a shout out to all those who are taken aback by the aura of words and want to test their vocabulary. So, all the word fanatics gear up and get ready to compete in the ultimate battle of words. "));
        list.add(new ModuleEvent("11.SPOKEN POETRY","People say that the performance of poetry is an art, just as much an art as the art of writing it.\n" +
                "\n" +
                "Hence, “Spoken Poetry” is for those who are passionate about portrayal of emotions and thoughts through words. So, recite aloud your self-written poem or any other poem of famous poets and leave us spellbound!\n" +
                "\n" +
                "You can choose whichever language you wish. "));
        list.add(new ModuleEvent("12.TECHart","As American director John Lasseter said “ The art challenges technology, and technology inspires art”. Their fusion always results in something innovative. So, all the budding artists out there, come and illustrate your ideas. You will be provided with pencil and paper. Carry your own colours along to add more beauty to our ideas.\n" +
                "\n" +
                "Contestants for TECHart will be selected on the basis of the prelims i.e. Logo Design. "));
        list.add(new ModuleEvent("13.SHUTTERWORLD","Hey all the shutterbugs out there! School Genius brings to you Shutterworld 4.0, the online photography contest, giving you a golden opportunity to display your skills and capture scintillating moments. Interested ones can submit their entries, the theme of which should be FESTIVAL or ARCHITECTURE. "));
        list.add(new ModuleEvent("14.MATH π- RATES","Math π- rates is especially designed for sharpening the mathematical skills of the students. All maths enthusiasts are welcomed to participate in this event. Come, turn the math mode on and bring out the inner mathematician in you!\n" +
                "\n" +
                "It will be held in two parts-\n" +
                "A. Prelims- MCQs to be solved within duration of 45 minutes.\n" +
                "B. Mains- MCQs to be solved within duration of 60 minutes"));
        list.add(new ModuleEvent("15.CRUSADE","“Crusade” invites all the avid debaters to participate in this event, where you'll have a healthy discussion on a given topic. This is a perfect platform to polish and showcase your debating skills. "));
        list.add(new ModuleEvent("16. XTREME TYPING"," School Genius 2018 proudly introduces Xtreme Typing, a rip roaring event where you have to put your typing speed to test. So, take a deep breath and fight in the ultimate battle of speed. For coming to the main event, you need to clear the prelims,\n" +
                "\n" +
                "Prelims - Memory test : Students will be asked some engrossing questions to test their memory. The highest scoring students will qualify to the next round. "));
        list.add(new ModuleEvent("17. PICTURE PERCEPTION","Love creative writing? Do you want to dive into the world of imagination and put forward your thoughts? Then Picture Perfection opens the door to you! School Genius 2018 brings forward this event where you will be given a picture and you need to process it in your own way and write down what you think of it. "));





               return list;
    }
    public static List<ModuleEvent> getVwarsEvents(){
        List<ModuleEvent> list = new ArrayList<>();

        list.add(new ModuleEvent("1. CS:GO","When the dust has settled there are only a select few who leave their mark permanently edged into history and have their own unique paths to become Eternal Legends. Sometimes its for the gifted, the ones who share sheer force of will bend the laws of physics. Then there are the godlike those who believe immortality and valhalla joyously awaits. Which one is in you - The Gifted? The Godlike? Is your team the best of the best? " ));
        list.add(new ModuleEvent("2. COD4 MODERN WARFARE", "Highly competitive multiplayer sport which serves as the ultimate test of decision making on the battlefield. With the pressures of a short time limit and bomb plant looming over every round, this game often delivers some of the best team and individual action gameplays. The fast-paced battle is back into action. The Assaulters, the Rushers, the pumped-up Shooters and lastly the Sniper. Has your team got it all? "));
        list.add(new ModuleEvent("3. FIFA 18", "When it comes to football, there's no denying it. There’s no better way to see someone’s true colors than by playing them in a game of FIFA. The club they play with, the formation they choose, and the coaching style they use all speak volumes as to what kind of person they are. What play style do you prefer? "));
        return list;
    }


    public static List<ModuleEvent> getMyndsnareEvents(){
        List<ModuleEvent> list = new ArrayList<>();
        list.add(new ModuleEvent("MYNDSNARE", "The quizzing extravaganza under Tecnoesis, the annual techno-management fest of NIT Silchar. Born in 2010, Myndsnare has been a huge success since then. As NIT Silchar Quiz Club is gaining popularity, eminent quizmasters like Late Vikram Joshi, Arnab Basu, Chandrakant Nair, Maharnab Gogoi, Aryapriya Ganguly, Abhra Das, Kapinjal Kumar Sharma and Manimugdha S Sharma have conducted Myndsnare in previous editions."));
        list.add(new ModuleEvent("1. THE SOUND AND THE FURY",
               "‘The Sound and The Fury: The General Quiz’ is Myndsnare’s main crowd attraction, which is conducted by the most eminent quizmasters of the country. Last year, NIT Silchar Quiz Club made a benchmark in its history by having Late Vikram Joshi as the quizmaster for this event. This edition is being conducted by Kushal Patel. He has conducted many reputable quizzing events under the banners of IIM and many more.",
                "","Puberun Boruah - 8474090921", "Monseej Purkayastha- 8723857227", "http://tecnoesis.in/module/myndsnare.pdf", "","" ));
        list.add(new ModuleEvent("2. SILICON VALLEY","This year Myndsnare brings “Silicon Valley:The Biz-Sci-Tech quiz”, to be conducted by Bedanga Das, alumnus of NIT Silchar, who is a prominent quizzer in the North Eastern quizzing circuit. From being one of the founding members of NIT Silchar Quiz Club to coming back to the college as a quiz master is always fascinating.",
                "","Puberun Boruah - 8474090921", "Monseej Purkayastha- 8723857227","http://tecnoesis.in/module/myndsnare.pdf", "","" ));
        list.add(new ModuleEvent("3.HUNGER GAMES", "‘Hunger Games: The Sports and Entertainment Quiz’ shall also be conducted by Kushan Patel. Be there to bring out the Sports and Entermainment geek within you, and partake in the most brilliant fundas and trivias in the genre. From sports to movies lets see who cracks the most out of it!",
                "","Puberun Boruah - 8474090921", "Monseej Purkayastha- 8723857227", "http://tecnoesis.in/module/myndsnare.pdf", "","" ));
        return list;
    }


    public static List<ModuleEvent> getCommingSoons(){
        List<ModuleEvent> list = new ArrayList<>();
        list.add(new ModuleEvent("COMING SOON!", "Details will be updated soon"));

        return list;
    }

    public static List<ModuleEvent> getCyberWarpEvents(){
        List<ModuleEvent> list = new ArrayList<>();
        list.add(new ModuleEvent("1. CYBERBOT","Want to see your code come alive and interact with you? Here is the perfect event for you then. Presenting before you CYBERBOT, the fun-oriented CSS Animations Workshop of Tecnoesis '18. All you need to do is to build a bot using HTML and CSS powered with some cool features using JAVASCRIPT. A 4-day workshop will be organized for the event. You will be learning everything from scratch (no prerequisite required). If you want to explore the world of web development, this is the right time to get started. ",
               "Build a bot using basic web development skills. ",
                "Navneet Gangwar - 9627993767","Tukan Dutta- 8011568663",  "http://tecnoesis.in/module/cyberbot.pdf",
                "https://goo.gl/forms/iJnAahnOFLq0o6iH3","", "Judging and Scoring Criteria","\n" +
                "    Functionality: 40\n" +
                "    Appearance: 25\n" +
                "    Innovation: 15\n" +
                "    Code structure: 20\n", "","" ));
        list.add(new ModuleEvent("2. NIBBLE CODE 2.0", "Are you awed by the simple solutions to impossible problem statements? Do you want to crack a few such by yourself?\n" +
                "\n" +
                "Here comes a chance to play with bytes and fight the bugs, and all you need to do is Code to Decode. So freshmen, buckle yourself to your seats and ready your minds to swish a flick!\n" +
                "\n" +
                "Introducing you to the realm of competitive coding, we present Nibble Code 2.0! Exclusively for freshmen, the contest will be much of a fun game which will have you scratch your heads over simple but tricky problem statements for 3 short hours of the day.\n" +
                "\n" +
                "To familiarize the enthusiasts with the competing environment, a two days’ workshop will be organized prior to the contest which will provide them with ample knowledge such that they can play well and battle amongst themselves for a better leaderboard position. ",
               "A few questions will be listed, participants need to code the solution using any programming language. Easey peasey.", "Neetya Pasari -9101013881",
               "Rasul Khan -9954331552", "http://tecnoesis.in/module/nibble.pdf", "https://docs.google.com/forms/d/e/1FAIpQLSeHh3sl5gWq0CjB6ygE3AsGlmnNKxdDRROwtjSram2il-HYng/viewform", ""));
        list.add(new ModuleEvent("3.CYBER HUNT BY EDPORTS", "A real-time exciting and mindboggling online competition based on the Application of the web browsing skills along with the IQ levels of the player. Come forward to test your knowledge and skills on a level never tested before, for Tecnoesis 2018 presents before you Cyber Hunt by Edports. ",
                "","Prashant Jha - 7987381031", "","http://tecnoesis.in/module/cyberhunt.docx",
                "https://docs.google.com/forms/d/e/1FAIpQLSeOdfMWan6V7Qh5bhlLGoaz14ksDFkjn8D2sDvb9N1eg0ugMg/viewform?usp=sf_link", "", "OBJECTIVE:", "To complete the event in the least possible time. ",
                "",""));
        list.add(new ModuleEvent("4.D.ART", "In today's generation most of the visualisation works like Machines, prototype of vehicles are first made in 3D for testing its performance. 3D modelling is also one of the major part of game development like 3D model, level design etc. The more realistic the graphics are the more players of the game. 3D is also a part of all CGI movie. So for the first time in Technoesis’ history we have a 3D modelling competition for you, where you need to make a 3D model based off of a 2D image. You may use any graphics software may it be a industry grade software Maya or open source software Blender. The event is to check your creative skills and to amplify your knowledge towards 3D development. ",
                "1.To create a 3D model of a 2D image along with proper texturing and lighting to make it look close to photorealism.\n" +
                        "\n" +
                        "2.Time allotted: 6 hrs ", "Kaushik Borah - 8134072095", "Arif Ahmed - 9954957843","http://tecnoesis.in/module/dart.pdf",
                "", ""));

        list.add(new ModuleEvent("5.TURING.AI", "“Celebrating Genuine Stupidity through Artificial Intelligence”\n" +
                "\n" +
                "The Annual Showdown of Tecnoesis catering to the Machine Learning Enthusiasts and the Data Scientists of NIT Silchar.\n" +
                "\n" +
                "The Event has 3 sub-events under it."));
        list.add(new ModuleEvent("5.1.DATA-STRATA :", "The Prime Attraction of the TURING.AI Event.", "", "Puberun Boruah - 8474090921",
                "Himanshu Tripathi - 9954964812","http://tecnoesis.in/module/turning.pdf", "","" ));
        list.add(new ModuleEvent("5.2.CHATBOT WORKSHOP","In this event the participants will be taught to make a Fully Functional Chatbot from scratch.\n" +
                "There is no prerequisite for this workshop.\n" +
                "The dates of the workshop are 26th and 27th October.",  "", "Puberun Boruah - 8474090921", "Himanshu Tripathi - 9954964812",
                "http://tecnoesis.in/module/pdf.svg", "",""));

        list.add(new ModuleEvent("5.3. WORKSHOP ON FACIAL EMOTION RECOGNITION","In this event the participants will be taught to develop a Facial Emotion Recognition Engine harnessing the power of Deep Learning.\n" +
                "The prerequisite for this workshop is Basic Programming.\n" +
                "The dates of the workshop are 27th and 28th October. ", "" ,"Akshay Gupta - 9175146842", "Rahul Debnath - 8721088790","Sanjib Das - 8135915757",
                "http://tecnoesis.in/module/turning.pdf", "",""));

        return list;
    }






}
