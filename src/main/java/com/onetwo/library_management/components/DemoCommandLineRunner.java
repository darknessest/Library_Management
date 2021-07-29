package com.onetwo.library_management.components;

import com.onetwo.library_management.controller.admin.AdminBookController;
import com.onetwo.library_management.entity.*;
import com.onetwo.library_management.repository.BookRepository;
import com.onetwo.library_management.repository.BorrowedBookRepository;
import com.onetwo.library_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
class DemoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        // add users
        User user = new User();
        user.setUsername("admin");
        user.setName("preregistered admin");
        user.setPhone("123456789011");
        user.setEmail("admin@mail.com");
        user.setPassword(passwordEncoder.encode("adminPass"));
        user.setUserRole(UserRole.ADMIN);

        userRepository.save(user);

        user = new User();
        user.setUsername("user1");
        user.setName("preregistered user");
        user.setPhone("110987654321");
        user.setEmail("user1@mail.com");
        user.setPassword(passwordEncoder.encode("user1Pass"));
        user.setUserRole(UserRole.USER);

        userRepository.save(user);

        // create books
//        Book book = new Book("Test isbn", "Test name", "Test serial name", "Test description", 12.5, 8);
//        Author author = new Author("Test author name", "Test description");
//        Category category = new Category("Test category name");
//        Publisher publisher = new Publisher("Test publisher name");
//
//        book.addAuthors(author);
//        book.addCategories(category);
//        book.addPublishers(publisher);
//
//        bookRepository.save(book);
//
//        Book book1 = new Book("Test isbn1", "Test name1", "Test serial name1", "Test description1", 22.0, 7);
//        Author author1 = new Author("Test author name1", "Test description1");
//        Category category1 = new Category("Test category name1");
//        Publisher publisher1 = new Publisher("Test publisher name1");
//
//        book1.addAuthors(author1);
//        book1.addCategories(category1);
//        book1.addPublishers(publisher1);
//
//        bookRepository.save(book1);
//
//        Book book2 = new Book("Test isbn2", "Test name2", "Test serial name2", "Test description2", 27.3, 10);
//        Author author2 = new Author("Test author name2", "Test description2");
//        Category category2 = new Category("Test category name2");
//        Publisher publisher2 = new Publisher("Test publisher name2");
//
//        book2.addAuthors(author2);
//        book2.addCategories(category2);
//        book2.addPublishers(publisher2);
//        bookRepository.save(book2);
        
        Book book = new Book("9787020002207", "红楼梦", "曹雪芹/高鹗", 50, 59.70, "《红楼梦》是一部百科全书式的长篇小说。以宝黛爱情悲剧为主线，以四大家族的荣辱兴衰为背景，描绘出18世纪中国封建社会的方方面面，以及封建专制下新兴资本主义民主思想的萌动。结构宏大、情节委婉、细节精致，人物形象栩栩如生，声口毕现，堪称中国古代小说中的经 典。");
        Author author = new Author("曹雪芹/高鹗", "");
        Category category = new Category("文学小说");
        Publisher publisher = new Publisher("人民文学出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787101003048", "史记", "", 20, 125.00, "史记是我国第一部通史。在史记之前，有以年代为次的“编年史”如春秋，有以地域为限的“国别史”如国语、战国策，有以文告档卷形式保存下来的“政治史”如尚书，可是没有上下几千年，包罗各方面，而又融会贯通，脉络分明，像史记那样的通史。");
        author = new Author("司马迁/张守节", "");
        category = new Category("历史著作");
        publisher = new Publisher("中华书局");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787547011607", "1984", "", 30, 25.00, "1984是一部杰出的政治寓言小说，也是一部幻想小说。作品刻画了人类在极权主义社会的生存状态，仿佛一个永不退色的警世标签，警醒世人提防这种预想中的黑暗成为现实。历经几十年，其生命力日益强大，被誉为20世纪影响最为深远的文学经典之一。");
        author = new Author("乔治▪奥威尔", "");
        category = new Category("科幻小说");
        publisher = new Publisher("万卷出版公司");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787536674257", "冰与火之歌（卷二）", "", 50, 65.00, "继《权力的游戏》之后，乔治·马丁推出了另一部恢宏之作，续篇《列王的纷争》。与罗伯特·乔丹不同的是，乔治·马丁牢牢把握住了精妙的情节和那些真实得令人惊叹的人物。《列王的纷争》具备了一部优秀奇幻小说需要的所有元素：爱情故事、宫廷阴谋、背叛和战争，并且远不止于此。乔治·马丁所展示的人物能够在不觉中触及你的灵魂深处，引发你强烈的爱憎感，如同他们本是你真实生活中的一部分。这使得《冰与火之歌》不仅仅在奇幻界堪称杰作，更是一部文学佳品。马丁拒绝演绎寻常的善恶套路，或是呈现读者可能期待的那些包裹着糖衣的英雄故事。他书中的人物具有不可思议的深度，无论善恶，他们都将赚取你的情感。这些再结合魔法元素的合理运用和对悬念与高潮设置的天赋感觉，造就了《列王的纷争》，如同《权力的游戏》这本你全心爱上的小说一样，也使乔治·马丁跻身当代最卓越的作家之列。");
        author = new Author("乔治▪R▪R▪马丁", "");
        category = new Category("科幻小说");
        publisher = new Publisher("重庆出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787806570920", "飘", "", 40, 40.00, "作品在描绘人物生活与爱情的同时，勾勒出南北双方在政治，经济，文化各个层次的异同，具有浓厚的史诗风格，堪称美国历史转折时期的真实写照，同时也成为历久不衰的爱情经典。");
        author = new Author("玛格丽特▪米切尔", "");
        publisher = new Publisher("译林出版社");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787506365437", "活着", "", 50, 20.00, "《活着(新版)》讲述了农村人福贵悲惨的人生遭遇。福贵本是个阔少爷，可他嗜赌如命，终于赌光了家业，一贫如洗。他的父亲被他活活气死，母亲则在穷困中患了重病，福贵前去求药，却在途中被国民党抓去当壮丁。经过几番波折回到家里，才知道母亲早已去世，妻子家珍含辛茹苦地养大两个儿女。此后更加悲惨的命运一次又一次降临到福贵身上，他的妻子、儿女和孙子相继死去，最后只剩福贵和一头老牛相依为命，但老人依旧活着，仿佛比往日更加洒脱与坚强。");
        author = new Author("余华", "");
        category = new Category("文学小说");
        publisher = new Publisher("作家出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("978753021113", "撒哈拉的故事", "", 50, 24.00, "三毛作品中最脍炙人口当属《撒哈拉的故事》，本书由十几篇精彩动人的散文结合而成，其中《沙漠中的饭店》，是三毛适应荒凉单调的沙漠生活后，重新拾笔的第一篇文章，从此之后，三毛便写出一系列以沙漠为背景的故事，倾倒了全世界的华文读者。");
        author = new Author("三毛", "");
        category = new Category("散文著作");
        publisher = new Publisher("北京十月文艺出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787542630544", "动物庄园", "", 50, 16.00, "《动物庄园》内容为：小说不属于人们所熟悉的蕴含教训的传统寓言，而是对现代政治神话的一种寓言式解构。“它是一部革命史，但它误入歧途，而且第一次偏离都那么有理由。”作者在1945年该书出版是如是说。奥威尔的传世之作，欧美15所名名牌大学投票选出“影响我成长的十《动物庄园(买中文版送英文版)》”之一，世界文坛最著名的政治讽喻小说。");
        author = new Author("乔治▪奥威尔", "");
        category = new Category("寓言小说");
        publisher = new Publisher("上海三联书店");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787508647357", "人类简史", "", 50, 68.00, "《人类简史：从动物到上帝》为什么能够在国际畅销书榜上爆冲？原因很简单，它处理的是历史的大问题、现代世界的大问题，而且，它的写作风格是刻骨铭心的生动。你会爱上它！");
        author = new Author("尤瓦尔▪赫拉利", "");
        category = new Category("历史著作");
        publisher = new Publisher("中信出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787544253994", "百年孤独", "", 50, 39.00, "《百年孤独》是魔幻现实主义文学的代表作，描写了布恩迪亚家族七代人的传奇故事，以及加勒比海沿岸小镇马孔多的百年兴衰，反映了拉丁美洲一个世纪以来风云变幻的历史。作品融入神话传说、民间故事、宗教典故等神秘因素，巧妙地糅合了现实与虚幻，展现出一个瑰丽的想象世界，成为20世纪最重要的经典文学巨著之一。1982年加西亚•马尔克斯获得诺贝尔文学奖，奠定世界级文学大师的地位，很大程度上乃是凭借《百年孤独》的巨大影响。");
        author = new Author("加西亚▪马尔克斯", "");
        category = new Category("文学小说");
        publisher = new Publisher("南海出版公司");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787536693968", "三体-Ⅱ", "", 50, 32.00, "自1999年处女作《鲸歌》问世以来，刘慈欣已发表短篇科幻小说三十余篇、出版长篇科幻小说六部，并创下连续八年荣获中国科幻最高奖“银河奖”的纪录。他的长篇作品《三体》开创《科幻世界》月刊连载原创作品的先例，成为2006年度最受关注、最畅销的科幻小说。");
        author = new Author("刘慈欣", "");
        publisher = new Publisher("重庆出版社");
        category = new Category("科幻小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787020008728", "三国演义(全二册)", "", 40, 39.00, "《三国演义》又名《三国志演义》、《三国志通俗演义》，是我国小说史上最著名最杰出的长篇章回体历史小说。 《三国演义》的作者是元末明初人罗贯中，由毛纶，毛宗岗父子批改。在其成书前，“三国故事”已经历了数百年的历史发展过程。在唐代，三国故事已广为流传，连儿童都很熟悉。随着市民文艺的发展，宋代的“说话”艺人，已有专门说三国故事的，当时称为“说三分”。元代出现的《三国志平话》，实际上是从说书人使用的本子，虽较简略粗糙，但已初肯《三国演义》的规模。罗贯中在群众传说和民间艺人创作的基础上，又依据陈寿《三国志》及裴松之注中所征引的资料（还包括《世说新语》及注中的资料），经过巨大的创作劳动，写在了规模宏伟的巨著——《三国志通俗演义》全书24卷，240回。后来经过毛纶，毛宗岗父子批改，形成我们现在所见的《三国演义》120回版");
        author = new Author("罗贯中", "");
        publisher = new Publisher("人民文学出版社");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787544258609", "白夜行", "", 40, 39.00, "一天当中，有太阳升起的时候，也有下沉的时候。人生也一样，有白天和黑夜，只是不会像真正的太阳那样，有定时的日出和日落。看个人，有些人一辈子都活在太阳的照耀下，也有些人不得不一直活在漆黑的深夜里。人害怕的，就是本来一直存在的太阳落下不再升起，也就是非常害怕原本照在身上的光芒消失。 我的天空里没有太阳，总是黑夜，但并不暗，因为有东西代替了太阳。虽然没有太阳那么明亮，但对我来说已经足够。凭借着这份光，我便能把黑夜当成白天。你明白吗？我从来就没有太阳，所以不怕失去。");
        author = new Author("东野圭吾", "");
        publisher = new Publisher("南海出版社");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787559614636", "房思琪的初恋乐园", "", 55, 45.00, "我不是对你失望，这个世界，或是生活、命运，或叫它神，或无论叫它什么，它好差劲。我现在读小说，如果读到赏善罚恶的好结局，我就会哭，我宁愿大家承认人间有一些痛苦是不能和解的；我最讨厌人说经过痛苦才成为更好的人，我好希望大家承认有些痛苦是毁灭的；我讨厌大团圆的抒情传统，正面思考是多么媚俗！可是，你知道我更恨什么吗？我宁愿我是一个媚俗的人，我宁愿无知，也不想要看过世界的背面。");
        author = new Author("林奕含", "");
        publisher = new Publisher("北京联合出版公司");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787020042494", "小王子", "", 12, 22.00, "“你们很美，但你们是空虚的。” 小王子任然在对她们说，“没有人能为你们去死。当然咯，我的那朵玫瑰花，一个普通的过路人以为她和你们一样。可是，她单独一朵就比你们全体更重要，因为她是我浇灌的。因为她是我放在花罩中的。因为她是我用屏风保护起来的。因为她身上的毛虫是我除灭的。因为我倾听过她的怨艾和自诩，甚至有时我聆听着她的沉默。因为她是我的玫瑰。”");
        author = new Author("安东尼▪德▪圣▪埃克苏佩里", "");
        publisher = new Publisher("人民文学出版社");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
        
        book = new Book("9787108006721", "天龙八部", "", 32, 96.00, "天龙八部乃金笔下的一部长篇小说，与《射雕》，《神雕》等 几部长篇小说一起被称为可读性最高的金庸小说。《天龙》的故事情节曲折，内容丰富，也曾多次被改编为电视作品。是金庸作品中集大成的一部。故事以北宋末年动荡的社会环境为背景，展开波澜壮阔的历史画卷，塑造了乔峰、段誉、 虚竹、慕容复等形象鲜明的人物，成为武侠史上的经典之作。故事精彩纷呈，人物命运悲壮多变，是可读性很强的作品，具有震撼人心的力量");
        author = new Author("金庸", "");
        publisher = new Publisher("生活▪读书▪新知三联书店");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787020024759", "围城", "钱钟书", 15, 19.00, "《围城》是钱钟书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出现过盗印本。1980年由作者重新修订之后，在中国大陆地区由人民文学出版社刊印。此后作者又曾小幅修改过几次。《围城》 自从出版以来，就受到许多人的推崇。由于1949年后长期无法重印，这本书逐渐淡出人们的视野。1960年代，旅美汉学家夏志清在《中国现代小说史》(A History of Modern Chinese Fiction)中对本书作出很高的评价，这才重新引起人们对它的关注。人们对它的评价一般集中在两方面，幽默的语言和对生活深刻的观察。从1990年代开始，也有人提出对本书的不同看法，认为这是一部被“拔高”的小说，并不是一部出色的作品。很多人认为这是一部幽默作品。除了各具特色的人物语言之外，作者夹叙其间的文字也显着机智与幽默。这是本书的一大特色。也有人认为这是作者卖弄文字，语言显得尖酸刻薄。但这一说法并不为大多数人接受。");
        author = new Author("曹雪芹/高鹗", "");
        publisher = new Publisher("人民文学出版社");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787532751471", "局外人", "", 45, 22.00, "《局外人》是法国作家加缪的成名作，同时也是存在主义文学的杰出作品之一，该书以一种客观记录式的“零度风格”，粗线条地描述了主人公默尔索在荒谬的世界中经历的种种荒谬的事，以及自身的荒诞体验。从参加母亲的葬礼到偶然成了杀人犯，再到被判处死刑，默尔索似乎对一切都无动于衷，他像一个象征性的符号，代表了一种普遍的存在，又像是一个血红色的灯塔，具有高度的警示性。然而，局外人现象的产生无疑是由这个世界本身所孕育的，默尔索的存在有其深刻的外部原因。");
        author = new Author("阿尔贝▪加缪", "");
        publisher = new Publisher("上海译文出版社");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787500627098", "沉默的大多数", "", 52, 27.00, "这本杂文随笔集包括思想文化方面的文章，涉及知识分子的处境及思考，社会道德伦理，文化论争，国学与新儒家，民族主义等问题；包括从日常生活中发掘出来的各种真知灼见，涉及科学与邪道，女权主义等；包括对社会科学研究的评论，涉及性问题，生育问题，同性恋问题，社会研究的伦理问题和方法问题等；包括创作谈和文论，如写作的动机，作者的师承，作者对小说艺术的看法，作者对文体格调的看法，对影视的看法等；包括少量的书评，其中既有对文学经典的评论，也有对当代作家作品的一些看法；最后，还包括一些域外生活的杂感以及对某些社会现象的评点。");
        author = new Author("王小波", "");
        publisher = new Publisher("中国青年出版社");
        category = new Category("杂文随笔");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787544211765", "许三观卖血记", "", 65, 16.80, "《许三观卖血记》是余华1995年创作的一部长篇小说，它以博大的温情描绘了磨难中的人生，以激烈的故事形式表达了人在面对厄运时求生的欲望。小说讲述了许三观靠着卖血渡过了人生的一个个难关，战胜了命运强加给他的惊涛骇浪，而当他老了，知道自己的血再也没有人要时，精神却崩溃了。");
        author = new Author("余华", "");
        publisher = new Publisher("南海出版社");
        category = new Category("文学小说");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787549530816", "文学回忆录", "", 42, 98.00, "本书首次披露的木心先生及其亲属的珍贵照片，由陈丹青先生和木心的外甥王韦先生提供。附印民国版本的世界文学书影，是一部民国出版史的私人旁证。");
        author = new Author("木心", "");
        publisher = new Publisher("广西师范大学出版社");
        category = new Category("回忆录");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787108041531", "邓小平时代", "", 65, 88.00, "哈佛大学傅高义教授倾十年心力完成的权威巨著《邓小平时代》，是对邓小平跌宕起伏的一生以及中国惊险崎岖的改革开放之路的全景式描述。作者对邓小平个人性格及执政风格进行了深层分析，并对中国改革开放史进行了完整而独到的阐释。书中涵盖丰富的中外档案资料和研究成果，以及为数众多的作者独家访谈。对中美建交、华国锋历史评估、改革开放的幕后曲折、邓小平和诸多当时关键人物之关系、香港问题、邓小平南巡等重大议题均有详述及剖析。本书既具学院研究的严谨专精，又对中国现实政治与事理人情有透彻把握，被誉为邓小平研究“纪念碑式”的著作。");
        author = new Author("傅高义", "");
        category = new Category("人物传记");
        publisher = new Publisher("生活▪读书▪新知三联书店");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787538276374", "上帝掷骰子吗", "", 25, 32.00, "《上帝掷骰子吗》这本书是关于量子论的故事。量子论是一个极为奇妙的理论：从物理角度来说，它在科学家中间引起了最为激烈的争议和关注；从现实角度来说，它给我们的社会带来了无与伦比的变化和进步；从科学史角度来说，也几乎没有哪段历史比量子论的创立得到了更为彻底的研究。然而不可思议的是，它的基本观点和假说至今没有渗透到大众的意识中去，这无疑又给它增添了一道神秘的光环。");
        author = new Author("曹天元", "");
        category = new Category("科普读物");
        publisher = new Publisher("辽宁教育出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787539957173", "永恒的终结", "", 48, 32.00, "24世纪，人类发明了时间力场。27世纪，人类在掌握时间旅行技术后，成立了一个叫做永恒时空（Eternity）的组织，在每个时代的背后，默默地守护着人类社会的发展。永恒时空以一个世纪为单位，并视每个世纪的发展需要而加以微调，以避免社会全体受到更大伤害。通过纠正过去的错误，将所有灾难扼杀在萌芽中，人类终于获得安宁的未来。然而，这种“绝对安全”的未来却在某一天迎来了终结。不知不觉中形成的因果链，仿佛从四面八方涌来的黑暗，即将吞噬全人类。");
        author = new Author("艾萨克▪阿西莫夫", "");
        category = new Category("科幻小说");
        publisher = new Publisher("江苏凤凰文艺出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787806992197", "飞鸟集", "", 96, 16.80, "《飞鸟集》是泰戈尔的代表作之一，也是世界上最杰出的诗集之一。白昼和黑夜、溪流和海洋、自由和背叛，都在泰戈尔的笔下合而为一，短小的语句道出了深刻的人生哲理，引领世人探寻真理和智慧的源泉。初读这些诗篇，如同在暴风雨过后的初夏清晨，推开卧室的窗户，看到一个淡泊清透的世界，一切都是那样清新、亮丽，可是其中的韵味却很厚实，耐人寻味。");
        author = new Author("拉宾德拉纳特▪泰戈尔", "");
        publisher = new Publisher("哈尔滨出版社");
        category = new Category("诗歌");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787806249420", "基地", "", 36, 21.00, "向来，过去才是历史，昨天才是历史。阿西莫夫却与众不同，他的《基地》系列写的是“未来的历史”，是“遥远未来的历史”，是“明天的历史”！");
        author = new Author("艾萨克▪阿西莫夫", "");
        category = new Category("科幻小说");
        publisher = new Publisher("天地出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787101001105", "唐诗三百首", "", 120, 45.60, "《唐诗三百首》的旧注本亦有许多种，其中以陈婉俊的补注本简明精当，流行最广。她的注解除简介作者生平外，比较注重语词名物的诠释，博引旁征，字梳句栉，对今天的读者仍有一定的参考价值。");
        author = new Author("蘅塘退士", "");
        publisher = new Publisher("中华书局");
        category = new Category("诗歌");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787535732309", "时间简史", "", 56, 45.00, "《时间简史》讲述是探索时间和空间核心秘密的故事，是关于宇宙本性的最前沿知识，包括我们的宇宙图像、空间和时间、膨胀的宇宙不确定性原理、基本粒子和自然的力、黑洞、黑洞不是这么黑、时间箭头等内容。第一版中的许多理论预言，后来在对微观或宏观宇宙世界观测中得到证实。");
        author = new Author("史蒂芬▪霍金", "");
        category = new Category("科普读物");
        publisher = new Publisher("湖南科学技术出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787111126768", "经济学原理（上）", "", 45, 42.00, "此《经济学原理》的第3版把较多篇幅用于应用与政策，较少篇幅用于正规的经济理论。书中主要从供给与需求、企业行为与消费者选择理论、长期经济增长与短期经济波动以及宏观经济政策等角度深入浅出地剖析了经济学家们的世界观。");
        author = new Author("格力高昂▪曼昆", "");
        category = new Category("专业书籍");
        publisher = new Publisher("机械工业出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787532739233", "枪炮、病菌与钢铁", "", 68, 45.00, "为什么是欧亚大陆人征服、赶走或大批杀死印第安人、澳大利亚人和非洲人，而不是相反？为什么么小麦和玉米、牛和猪以及现代世界的其他一些“不了起的”作物和牲畜出现在这些特定地区，而不是其他地区？在这部开创性的著作中，演化生物学家贾雷德.戴蒙德揭示了事实上有助于形成历史最广泛模式的环境因素，从而以震撼人心的力量摧毁了以种族主义为基础的人类史理论，因其突出价值和重要性，本书荣获1998年美国普利策奖和英国科普书奖，并为《纽约时报》畅销书排行榜作品。");
        author = new Author("贾雷德▪戴蒙德", "");
        category = new Category("科普读物");
        publisher = new Publisher("上海世纪出版集团");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787115138804", "社会心理学", "", 32, 68.00, "《社会心理学》这本书被美国700多所大学或学院的心理系所采用，是这一领域的主导教材，已经成为评价其他教材的标准。");
        author = new Author("戴维▪迈尔斯", "");
        category = new Category("专业书籍");
        publisher = new Publisher("人民邮电出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787020036509", "茶馆", "", 75, 9.80, "三幕话剧《茶馆》以北京一家大茶馆为背景，描写了清末、民初、抗战胜利以后三个历史时期的北京生活风貌，深刻地写出了王利发等人的真实命运。");
        author = new Author("老舍", "");
        category = new Category("戏剧");
        publisher = new Publisher("人民文学出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787020018567", "雷雨", "", 65, 9.20, "《雷雨》所展示的是一幕人生大悲剧，是命运对人残忍的作弄。专制、伪善的家长，热情、单纯的青年，被情爱烧疯了心的魅惑的女人，痛悔着罪孽却又不自知地犯下更大罪孽的公子哥，还有家庭的秘密，身世的秘密，所有这一切在一个雷雨夜爆发。有罪的，无辜的人一起走向毁灭。曹禺以极端的雷雨般狂飙恣肆的方式，发泄被抑压的愤懑，毁谤中国的家庭和社会。");
        author = new Author("曹禺", "");
        category = new Category("戏剧");
        publisher = new Publisher("人民文学出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787301204689", "全球通史", "", 45, 168.00, "《全球通史》由斯塔夫里阿诺斯著，吴象婴、梁赤民、董书慧、王昶译，作者在本书中采用全新的史学观点和方法，将整个世界看作一个不可分割的有机的统一体，从全球的角度而不是从某一国家或某一地区的角度来考察世界各地区人类文明的产生和发展，把研究重点放在对人类历史进程有重大影响的诸历史运动、诸历史事件和它们之间的相互关联和相互影响上，努力反映局部与整体的对抗以及它们之间的相互作用。本书一经问世，受到著名历史学家汤因比和巴勒棵拉夫高度评价，立即被译成多种文字，流传甚广，影响很大。");
        author = new Author("斯塔夫里阿诺斯", "");
        publisher = new Publisher("北京大学出版社");
        category = new Category("科普读物");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787030107596", "从一到无穷大", "", 18, 29.00, "《从一到无穷大：科学中的事实和臆测》是当今世界最有影响的科普经典名著之一，1970年代末由科学出版社引进出版后，曾在国内引起很大反响，直接影响了众多的科普工作者。");
        author = new Author("乔治▪伽莫夫", "");
        publisher = new Publisher("科学出版社");
        category = new Category("科普读物");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787209041065", "设计中的设计", "", 23, 48.00, "设计到底是什么？作为一名从业二十余年并且具有世界影响的设计师，原研哉对自己提出了这样一个问题。为了给出自己的答案，他走了那么长的路，做了那么多的探索。“RE-DESIGN——二十一世纪的日常用品再设计”展真是一个有趣的展览，但又不仅仅是有趣，它分明是为我们揭示了“日常生活”所具有的无限可能性。若我们能以满怀新鲜的眼神去观照日常，“设计”的意义定会超越技术的层面，为我们的生活观和人生观注入力量。");
        author = new Author("原研哉", "");
        publisher = new Publisher("山东人民出版社");
        category = new Category("专业书籍");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787801872166", "中国哲学简史", "", 40, 38.00, "作者冯友兰于1947年在美国宾夕法尼亚大学受聘担任讲座教授，讲授中国哲学史。其英文讲稿后经整理写成《中国哲学简史》，于1948年由美国麦克米兰公司出版。此书一出，立即成为西方人了解和学习中国哲学的首选入门书。其后又有法文、意大利文、西班牙文、南斯拉夫文、日文等译本出版。多年来，这部专著一直是世界各大学中国哲学的通用教材，在西方影响很大。");
        author = new Author("冯友兰", "");
        publisher = new Publisher("新世界出版社");
        category = new Category("科普读物");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787563349128", "人类群星闪耀时", "", 42, 18.00, "《人类群星闪耀时》由奥地利著名小说家创作。《人类群星闪耀时》内容：涌动着匪徒、探险家、叛乱者兼英雄血液的巴尔沃亚成为第一个看到太平洋的欧洲人；仅仅一秒钟的优柔寡断，格鲁希元帅就决定了拿破仑在滑铁卢之战中失败的命运；七十多岁的歌德像情窦初开的男孩爱上了十几岁的少女，求婚未遂之后，老人在萧萧秋色中一气呵成地创作了《玛丽恩巴德悲歌》；流亡国外的列宁不顾自己的荣辱毁誉，乘坐一列铅封的火车取道德国返回俄国，十月革命就这样开启了历史的火车头……");
        author = new Author("斯蒂芬▪茨威格", "");
        category = new Category("人物传记");
        publisher = new Publisher("广西师范大学出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787532777532", "长日将尽", "", 42, 48.00, "《长日将尽》是诺奖得主石黑一雄1989年获布克奖的作品，也是石黑一雄最重要的代表作。小说以管家史蒂文斯的回忆展开，讲述了自己为达林顿勋爵服务的三十余年时光里的种种经历；虽然达到了职业巅峰，但史蒂文斯过于冷酷地压抑自我情感，追求完美履行职责，而在父亲临终前错过最后一面，之后又与爱情擦肩而过。小说通过主人公的回忆，将一个人的生命旅程在读者眼前抽丝剥茧，同时也折射出一战与二战之间那段非常时期的国际政治格局。");
        author = new Author("石黑一雄", "");
        category = new Category("文学小说");
        publisher = new Publisher("上海译文出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787532744800", "荒原狼", "", 45, 13.00, "小说的主人公哈勒尔是个正直的作家，他鄙视现代社会生活方式，常常闭门不出，令人窒息的空气使他陷于精神分裂的境地。一天他偶尔读到一本《评荒原狼》的小书，顿觉大梦初醒，认为自己就是一个“人性”和“狼性”并存的荒原狼。之后他应邀参加聚会，发现与会者都有狭隘的民族主义观点，而他的反战言论遭到斥责，更觉自己孤独；回家时他遇到酒吧女郎赫尔米娜，获得肉欲欢乐；经赫尔米娜介绍他又结识了音乐人帕布洛和一姑娘玛丽亚，他在音乐和感官享受中忘却了一切烦恼和忧虑。但当他看到赫尔米娜和帕布洛亲近时，便“狼性”大发，出于嫉妒将赫尔米娜杀死。小说幻想色彩浓郁，象征意味深远，被认为有“超现实主义”风格；托马斯·曼称它为“德国的尤利西斯”。");
        author = new Author("赫尔曼▪黑塞", "");
        category = new Category("文学小说");
        publisher = new Publisher("上海译文出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787020035946", "哈姆雷特", "", 36, 7.00, "本书具有很强的经典性及学术性，该书不仅是语言文学专业大学生从事专业学习和学术研究不可缺少的重要书籍，同时也是其他专业大学生加强人文素养、丰富文化底蕴、促进专业学习的重要读物。可供不同专业的大学生阅读收藏。");
        author = new Author("威廉▪莎士比亚", "");
        category = new Category("戏剧");
        publisher = new Publisher("人民文学出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787108011114", "别闹了，费曼先生", "", 25, 22.00, "费曼得过诺贝尔奖，是现代最伟大的理论物理学家之一。但他同时也可能是历史上唯一被按摩院请去画裸体画、偷偷打开放着原子弹机密文件的保险箱，在巴西桑巴乐团担任鼓手的科学家。他曾跟爱因斯坦和波尔等大师讨论物理问题，也曾在赌城跟职业赌徒研究输赢机率。");
        author = new Author("查理德▪费曼", "");
        category = new Category("人物传记");
        publisher = new Publisher("生活▪读书▪新知三联书店");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787544258661", "了不起的盖茨比", "", 12, 25.00, "中西部小子盖茨比到东部闯荡一夕致富，他在自己的豪宅夜夜宴客，俨然慷慨荒唐的富豪大亨；他梦幻地看着纽约长岛上一座闪着绿光的灯塔，寻觅着梦寐以求的女人黛西。邻居尼克，眼看着盖茨比的宾客们接受他的招待却冷漠无情，眼看着盖茨比奋力追求那腐败的虚华。盖兹比最后的结局，让尼克对东部浮华的名流生活梦碎，宛如看着繁华楼起再看着它楼塌。");
        author = new Author("弗▪司各特▪菲茨杰拉德", "");
        category = new Category("文学小说");
        publisher = new Publisher("南海出版公司");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787020015092", "牡丹亭", "", 26, 14.00, "《牡丹亭》是明代大曲家汤显祖的代表作，这时作家的思想和艺术都已经成熟。明代话本小说《杜丽娘慕色还魂》为《牡丹亭》提供了基本情节。《牡丹亭》在《惊梦》《寻梦》《闹殇》各出的宾白中还保留了话本的若干原句。在小说中，杜丽娘还魂后，门当户对的婚姻顺利缔成；而在戏曲中，汤显祖进 行了脱胎换骨的创造性劳动，把小说中的传说故事同明代社会的现实生活结合起来，使它具有强烈的反礼教、反封建色彩，焕发出追求个性自由的光辉理想。");
        author = new Author("汤显祖", "");
        category = new Category("戏剧");
        publisher = new Publisher("人民文学出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787806574317", "海底两万里", "", 20, 19.00, "本书是法国举世闻名的科幻小说作家儒尔·凡尔纳的代表作之一。");
        author = new Author("儒勒▪凡尔纳", "");
        category = new Category("科幻小说");
        publisher = new Publisher("译林出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787508630069", "史蒂夫▪乔布斯传", "", 32, 68.00, "这本乔布斯唯一授权的官方传记，在2011年上半年由美国出版商西蒙舒斯特对外发布出版消息以来，备受全球媒体和业界瞩目，这本书的全球出版日期最终确定为2011年11月21日，简体中文版也将同步上市。");
        author = new Author("沃尔特▪艾萨克森", "");
        category = new Category("人物传记");
        publisher = new Publisher("中信出版社");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787121139512", "浪潮之巅", "", 26, 55.00, "近一百多年来，总有一些公司很幸运地、有意识或无意识地站在技术革命的浪尖之上。在这十几年间，它们代表着科技的浪潮，直到下一波浪潮的来临。");
        author = new Author("吴军", "");
        publisher = new Publisher("电子工业出版社");
        category = new Category("科普读物");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787115282828", "数学之美", "", 45, 45.00, "几年前，“数学之美”系列文章原刊载于谷歌黑板报，获得上百万次点击，得到读者高度评价。读者说，读了“数学之美”，才发现大学时学的数学知识，比如马尔可夫链、矩阵计算，甚至余弦函数原来都如此亲切，并且栩栩如生，才发现自然语言和信息处理这么有趣。");
        author = new Author("吴军", "");
        publisher = new Publisher("人民邮电出版社");
        category = new Category("科普读物");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }

        book = new Book("9787544270878", "解忧杂货店", "", 25, 39.00, "如今回顾写作过程，我发现自己始终在思考一个问题：站在人生的岔路口，人究竟应该怎么做？我希望读者能在掩卷时喃喃自语：我从未读过这样的小说。——东野圭吾");
        author = new Author("东野圭吾", "");
        category = new Category("文学小说");
        publisher = new Publisher("南海出版公司");
        book.addAuthors(author);
        book.addCategories(category);
        book.addPublishers(publisher);
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("can't add book " + book.getName());
        }
    }
}