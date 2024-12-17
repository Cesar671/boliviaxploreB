package com.movil.boliviaXplore.loaders;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.movil.boliviaXplore.repository.CategoryRepository;
import com.movil.boliviaXplore.repository.EventRepository;
import com.movil.boliviaXplore.repository.ImageRepository;
import com.movil.boliviaXplore.models.Category;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Image;

@Component("datacategoryloader")
public class DataLoader implements ApplicationRunner{
    private final CategoryRepository categoryRepository;
    private final EventRepository eventRepository;
    private final ImageRepository imageRepository;

    public DataLoader(EventRepository eventRepository,CategoryRepository categoryRepository, ImageRepository imageRepository){
        this.categoryRepository = categoryRepository;
        this.eventRepository = eventRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws IOException{
        if( categoryRepository.count() == 0 ){
            Category category1 = new Category();
            category1.setNombreCategoria("Celebraciones Folcloricas");
            Category category2 = new Category();
            category2.setNombreCategoria("Festivales Tradicionales");
            Category category3 = new Category();
            category3.setNombreCategoria("Lugares Turisticos");
            Category category4 = new Category();
            category4.setNombreCategoria("Conciertos Conteporaneos");
            Category category5 = new Category();
            category5.setNombreCategoria("Exposiciones de Arte");
            Category category6 = new Category();
            category6.setNombreCategoria("Ferias Artesanales");
            
            this.categoryRepository.save(category1);
            this.categoryRepository.save(category2);
            this.categoryRepository.save(category3);
            this.categoryRepository.save(category4);
            this.categoryRepository.save(category5);
            this.categoryRepository.save(category6);

            LocalDate a = LocalDate.of(2024, 11, 02);
            LocalDate b = LocalDate.of(2026, 11, 04);

            Event eventGetted = this.registerEvent(
                "Cristo de la Concordia",
                "El Cristo de la Concordia es una imponente estatua de Jesucristo ubicada en la ciudad de Cochabamba, en la cima del Cerro San Pedro. Con una altura de 34.20 metros (sin contar la base), es una de las estatuas de Cristo más grandes del mundo, superada solo por algunas variantes modernas."
                , "La construcción comenzó en 1987 y fue inaugurada el 20 de noviembre de 1994.\n" + //
                                        "Fue inspirada por el famoso Cristo Redentor de Río de Janeiro, Brasil.\n" + //
                                        "El proyecto fue dirigido por los arquitectos César y Wálter Terrazas Pardo.\n" + //
                                        "La estatua simboliza la paz y la unión de los cochabambinos y es un importante atractivo turístico y religioso.", 
                                        -17.38452271820826, -66.13498326161248,
                                         true,
                                         a, 
                                         b, 
                                         3);

            this.registerImage("bbynjdnazvxa4kozbc0u", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734443501/bbynjdnazvxa4kozbc0u.jpg", 
            "bbynjdnazvxa4kozbc0u", 
            eventGetted);
            this.registerImage("lqiat2xusoyizbsoj5ay", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734443506/lqiat2xusoyizbsoj5ay.jpg", 
            "lqiat2xusoyizbsoj5ay", 
            eventGetted);
            this.registerImage("tvitybrvotkjo143zhjj", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734443512/tvitybrvotkjo143zhjj.jpg", 
            "tvitybrvotkjo143zhjj", 
            eventGetted);
            this.registerImage("hqbln0detevojmr5njyz", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734443519/hqbln0detevojmr5njyz.jpg", 
            "hqbln0detevojmr5njyz", 
            eventGetted);

            Event eventGetted2 = this.registerEvent(
                "Palacio Portales (Centro Cultural Simón I. Patiño)",
                "Construida a inicios del siglo XX como residencia de Simón I. Patiño", 
                "el magnate del estaño. Hoy es un centro cultural con exposiciones de arte y eventos.", 
                                        -17.374730390510376, -66.15314610502934,
                                         true,
                                         a, 
                                         b, 
                                         3);
            this.registerImage("kc3vzmeezagedwv8qiyi", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445190/kc3vzmeezagedwv8qiyi.jpg", 
            "kc3vzmeezagedwv8qiyi", 
            eventGetted2);
            this.registerImage("gv705vahkaish5yzfdcl", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445191/gv705vahkaish5yzfdcl.jpg", 
            "gv705vahkaish5yzfdcl", 
            eventGetted2);
            this.registerImage("u71fo1qik7dmqwnahxuy", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445197/u71fo1qik7dmqwnahxuy.jpg", 
            "u71fo1qik7dmqwnahxuy", 
            eventGetted2);
            this.registerImage("j1wwpiigtqnhdl3vekjg", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445201/j1wwpiigtqnhdl3vekjg.jpg", 
            "j1wwpiigtqnhdl3vekjg", 
            eventGetted2);

            Event eventGetted3 = this.registerEvent(
                "Parque Nacional Tunari",
                "Una reserva natural ideal para el ecoturismo, con senderos, lagunas y montañas.", 
                "Este parque protege una vasta área montañosa que rodea la ciudad y es vital para la conservación del ecosistema local. Es un refugio para flora y fauna andina.", 
                -17.33569696136417, -66.13992321852305,
                                         true,
                                         a, 
                                         b, 
                                         3);
            this.registerImage("dwzg0yo0nqzkryqek8ky", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445451/dwzg0yo0nqzkryqek8ky.jpg", 
            "dwzg0yo0nqzkryqek8ky", 
            eventGetted3);
            this.registerImage("kgruarbpevms3emlbbke", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445458/kgruarbpevms3emlbbke.jpg", 
            "kgruarbpevms3emlbbke", 
            eventGetted3);
            this.registerImage("m212turyxyqgw8nzgu5e", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445465/m212turyxyqgw8nzgu5e.jpg", 
            "m212turyxyqgw8nzgu5e", 
            eventGetted3);

            Event eventGetted4 = this.registerEvent(
                "Laguna Alalay",
                "Una laguna artificial en la ciudad, rodeada de áreas verdes y espacios para caminatas y deportes.", 
                "Creada en los años 40 para el control de aguas, hoy es un espacio de recreación y un punto importante para la observación de aves.", 
                -17.40788008649283, -66.13802100802646,
                                         true,
                                         a, 
                                         b, 
                                         3);
            this.registerImage("f9mtpre9av5wz6bxlph7", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445635/f9mtpre9av5wz6bxlph7.jpg", 
            "f9mtpre9av5wz6bxlph7", 
            eventGetted4);
            this.registerImage("gt8uyw2khichysu0zrll", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445637/gt8uyw2khichysu0zrll.jpg", 
            "gt8uyw2khichysu0zrll", 
            eventGetted4);
            this.registerImage("gavdf4nafyhr8x2qbcaw", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445641/gavdf4nafyhr8x2qbcaw.jpg", 
            "gavdf4nafyhr8x2qbcaw", 
            eventGetted4);
            this.registerImage("ht0ms9mbqm8my6wzrqre", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445647/ht0ms9mbqm8my6wzrqre.jpg", 
            "ht0ms9mbqm8my6wzrqre", 
            eventGetted4);
            Event eventGetted5 = this.registerEvent(
                "Pairumani - Parque Ecoturístico",
                "Un parque con cascadas, senderos y áreas verdes perfecto para un día de campo.", 
                "Fue parte de las tierras de Simón I. Patiño y se conserva como un espacio natural que promueve el ecoturismo.", 
                -17.344647437639928, -66.3316565915364,
                                         true,
                                         a, 
                                         b, 
                                         3);
    this.registerImage("h8gxaywo4rkjtlz10t0i", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445960/h8gxaywo4rkjtlz10t0i.jpg", 
            "h8gxaywo4rkjtlz10t0i", 
            eventGetted5);
            this.registerImage("jlvbgqfbthlim0k7oiac", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445966/jlvbgqfbthlim0k7oiac.png", 
            "jlvbgqfbthlim0k7oiac", 
            eventGetted5);
            this.registerImage("v5tpvz2le2dd2xqdmsbt", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445971/v5tpvz2le2dd2xqdmsbt.jpg", 
            "v5tpvz2le2dd2xqdmsbt", 
            eventGetted5);
            this.registerImage("qzixfhy9hbtk2wmtn6z5", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734445976/qzixfhy9hbtk2wmtn6z5.jpg", 
            "qzixfhy9hbtk2wmtn6z5", 
            eventGetted5);

            Event eventGetted6 = this.registerEvent(
                "Laguna Corani",
                "Un embalse de agua rodeado de montañas y bosques, ideal para la pesca y deportes acuáticos.", 
                "FConstruido como represa hidroeléctrica, se convirtió en un atractivo turístico debido a su belleza natural y tranquilidad.", 
                -17.26621564253225, -65.90004299387782,
                                         true,
                                         a, 
                                         b, 
                                         3);
            this.registerImage("dhzvrkfdpz0gbaapx8hw", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446238/dhzvrkfdpz0gbaapx8hw.jpg", 
            "dhzvrkfdpz0gbaapx8hw", 
            eventGetted6);
            this.registerImage("boxhhjg9vfu1i0ztyaoe", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446242/boxhhjg9vfu1i0ztyaoe.jpg", 
            "boxhhjg9vfu1i0ztyaoe", 
            eventGetted6);
            this.registerImage("ukxuiciuus82y2rmkmlw", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446250/ukxuiciuus82y2rmkmlw.jpg", 
            "ukxuiciuus82y2rmkmlw", 
            eventGetted6);

            Event eventGetted7 = this.registerEvent(
                "Convento de Santa Teresa",
                "Un convento colonial que hoy funciona como museo, mostrando la vida religiosa del siglo XVIII.", 
                "Fundado en 1760, sus paredes cuentan historias de las monjas Carmelitas Descalzas y su vida de clausura en la época colonial.", 
                -17.38615189952525, -66.15885569838967,
                                         true,
                                         a, 
                                         b, 
                                         3);
                    this.registerImage("kxb74wgpj6eyiilrt1dm", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446412/kxb74wgpj6eyiilrt1dm.jpg", 
            "kxb74wgpj6eyiilrt1dm", 
            eventGetted7);
            this.registerImage("kwy3juwxrnmfgqhpubi4", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446417/kwy3juwxrnmfgqhpubi4.jpg", 
            "kwy3juwxrnmfgqhpubi4", 
            eventGetted7);
            this.registerImage("urv4h2z0knnkdxtqvome", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446420/urv4h2z0knnkdxtqvome.jpg", 
            "urv4h2z0knnkdxtqvome", 
            eventGetted7);

            Event eventGetted8 = this.registerEvent(
                "Plaza 14 de Septiembre",
                "La plaza principal de Cochabamba, un punto de encuentro rodeado por edificios históricos.", 
                "Es el lugar donde se celebran las festividades más importantes de la ciudad. Fue testigo de la revolución del 14 de septiembre de 1810, cuando Cochabamba se levantó por la independencia.", 
                -17.393812707063102, -66.15706069948624,
                                         true,
                                         a, 
                                         b, 
                                         3);
                this.registerImage("qtuuapb5pmkz61g7ldk6", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446575/qtuuapb5pmkz61g7ldk6.jpg", 
            "qtuuapb5pmkz61g7ldk6", 
            eventGetted8);
            this.registerImage("ezkad9wjaggu9js4cnmh", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446588/ezkad9wjaggu9js4cnmh.png", 
            "ezkad9wjaggu9js4cnmh", 
            eventGetted8);
            this.registerImage("rmqhyvbsztnsczqbrsjg", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446589/rmqhyvbsztnsczqbrsjg.jpg", 
            "rmqhyvbsztnsczqbrsjg", 
            eventGetted8);
            this.registerImage("rq5co3zyivbmrlb8icil", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446595/rq5co3zyivbmrlb8icil.avif", 
            "rq5co3zyivbmrlb8icil", 
            eventGetted8);
            Event eventGetted9 = this.registerEvent(
                "Plaza Colón",
                "Es una de las plazas más importantes y tradicionales de Cochabamba, conocida por sus amplias áreas verdes, monumentos y ambiente relajado. Está ubicada cerca del centro histórico de la ciudad y es un lugar perfecto para pasear, descansar o disfrutar de eventos culturales.", 
                "La plaza fue diseñada durante el período republicano y lleva el nombre de Cristóbal Colón, como homenaje al navegante. A lo largo de los años, ha sido un espacio de encuentro para familias, turistas y estudiantes debido a su cercanía a colegios y universidades.", 
                -17.387862812258916, -66.15583027619354,
                                         true,
                                         a, 
                                         b, 
                                         3);
            this.registerImage("zlpsckoscrkncoo7l7tc", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446855/zlpsckoscrkncoo7l7tc.jpg", 
            "zlpsckoscrkncoo7l7tc", 
            eventGetted9);
            this.registerImage("xozitrzxhbu2im14t9nd", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446858/xozitrzxhbu2im14t9nd.jpg", 
            "xozitrzxhbu2im14t9nd", 
            eventGetted9);
            this.registerImage("qh654ahu2ejhw1qukefr", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734446864/qh654ahu2ejhw1qukefr.jpg", 
            "qh654ahu2ejhw1qukefr", 
            eventGetted9);
            Event eventGetted10 = this.registerEvent(
                "El Prado",
                "El Prado es un bulevar arbolado ubicado en el corazón de Cochabamba. Es un espacio amplio con áreas verdes, fuentes y bancas, donde tanto locales como turistas disfrutan de paseos, comidas y actividades al aire libre. A lo largo del bulevar, hay una gran cantidad de cafés, restaurantes, heladerías y tiendas, lo que lo convierte en un punto social y cultural de la ciudad.", 
                "Originalmente, El Prado era una avenida con jardines diseñada durante la primera mitad del siglo XX como un paseo elegante para la burguesía cochabambina. A lo largo de los años, el lugar ha crecido en popularidad y ha mantenido su carácter distintivo de espacio recreativo y punto de encuentro."
                                        , 
                                        -17.384801454973005, -66.15790094144648,
                                         true,
                                         a, 
                                         b, 
                                         3);
            this.registerImage("uglgj9wrelujhmrg0mw6", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734447180/uglgj9wrelujhmrg0mw6.jpg", 
            "uglgj9wrelujhmrg0mw6", 
            eventGetted10);
            this.registerImage("bbh1otv1ojwadijw3ya6", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734447156/bbh1otv1ojwadijw3ya6.jpg", 
            "bbh1otv1ojwadijw3ya6", 
            eventGetted10);
            this.registerImage("xo5sgju4jgbmdkxgvzn7", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734447195/xo5sgju4jgbmdkxgvzn7.jpg", 
            "xo5sgju4jgbmdkxgvzn7", 
            eventGetted10);

            Event eventGetted11 = this.registerEvent(
                "Museo Arqueológico de la Universidad Mayor de San Simón (UMSS)",
                "Alberga una colección de piezas precolombinas, como cerámicas, textiles y restos óseos de culturas antiguas que habitaron Bolivia.", 
                "Fundado en 1951, es uno de los centros más importantes para la investigación y preservación del patrimonio arqueológico regional."
                                        , 
                                        -17.39524756030184, -66.15727607087086,
                                         true,
                                         a, 
                                         b, 
                                         3);
                this.registerImage("hie0iuct8japyvacfyad", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734447824/hie0iuct8japyvacfyad.jpg", 
            "hie0iuct8japyvacfyad", 
            eventGetted11);
            this.registerImage("gv6odaxqoj2dohf61mec", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734447826/gv6odaxqoj2dohf61mec.jpg", 
            "gv6odaxqoj2dohf61mec", 
            eventGetted11);
            this.registerImage("limyrmqznt8zrzesaipj", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734447830/limyrmqznt8zrzesaipj.jpg", 
            "limyrmqznt8zrzesaipj", 
            eventGetted11);
            this.registerImage("jolqktntf8czrnx0m6nx", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734447834/jolqktntf8czrnx0m6nx.jpg", 
            "jolqktntf8czrnx0m6nx", 
            eventGetted11);

            Event eventGetted12 = this.registerEvent(
                "Museo de Historia Natural \"Alcide d'Orbigny\"",
                "Exhibe fósiles, animales disecados y plantas nativas, enfocándose en la biodiversidad boliviana. Ideal para los amantes de la naturaleza.", 
                "Nombrado en honor al naturalista francés Alcide d'Orbigny, quien exploró Bolivia en el siglo XIX. Abrió sus puertas en 2001."
                                        , 
                                        -17.37377181127687, -66.15370713386481,
                                         true,
                                         a, 
                                         b, 
                                         3);
                                         this.registerImage("qdhs3yl4hj5kqrhfefgh", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734448032/qdhs3yl4hj5kqrhfefgh.jpg", 
            "qdhs3yl4hj5kqrhfefgh", 
            eventGetted12);
            this.registerImage("jn95clp3dkoj4jswewuo", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734448037/jn95clp3dkoj4jswewuo.jpg", 
            "jn95clp3dkoj4jswewuo", 
            eventGetted12);
            this.registerImage("t0mem7z9qplsmwhwghgi", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734448056/t0mem7z9qplsmwhwghgi.jpg", 
            "t0mem7z9qplsmwhwghgi", 
            eventGetted12);
            Event eventGetted13 = this.registerEvent(
                "Museo Martín Cárdenas",
                "Dedicado al botánico Martín Cárdenas, muestra herbarios, plantas disecadas y objetos personales del científico.", 
                "Creado en honor a Cárdenas, un referente en la botánica boliviana, reconocido por su aporte a la clasificación de flora nativa."
                                        , 
                                        -17.3925973874009, -66.1605509843652,
                                         true,
                                         a, 
                                         b, 
                                         3);
                                         this.registerImage("dfipquqv9zrr7p6te8gf", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734448330/dfipquqv9zrr7p6te8gf.jpg", 
            "dfipquqv9zrr7p6te8gf", 
            eventGetted13);
            this.registerImage("unfkyawhflt3cdzzot7d", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734448335/unfkyawhflt3cdzzot7d.jpg", 
            "unfkyawhflt3cdzzot7d", 
            eventGetted13);
            this.registerImage("r8t3dpshof5oxc1ywegm", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734448346/r8t3dpshof5oxc1ywegm.jpg", 
            "r8t3dpshof5oxc1ywegm", 
            eventGetted13);

            LocalDate a1 = LocalDate.of(2025, 8, 15);
            LocalDate b1 = LocalDate.of(2025, 8, 18);

            Event eventGetted14 = this.registerEvent(
                "Fiesta de la Virgen de Urkupiña",
                "Celebrada cada 15 de agosto en Quillacollo, es una de las festividades más importantes de Bolivia. Miles de fieles y turistas asisten para rendir homenaje a la Virgen", 
                "Nació en el siglo XVII, cuando una pastorcita indígena tuvo una visión de la Virgen María en el cerro de Cota. Es conocida como la \"Patrona de la Integración Nacional\"."
                                        , 
                                        -17.394216696453988, -66.27935952773699,
                                         true,
                                         a1, 
                                         b1, 
                                         1);
                                        this.registerImage("sdbvncpxnygw8uqx587v", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734449037/sdbvncpxnygw8uqx587v.jpg", 
            "sdbvncpxnygw8uqx587v", 
            eventGetted14);
            this.registerImage("s36dfxjpysx1e7cdhih3", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734449042/s36dfxjpysx1e7cdhih3.jpg", 
            "s36dfxjpysx1e7cdhih3", 
            eventGetted14);
            this.registerImage("mq8kjvy31kwifag2xf4o", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734449170/mq8kjvy31kwifag2xf4o.jpg", 
            "mq8kjvy31kwifag2xf4o", 
            eventGetted14);
            LocalDate a2 = LocalDate.of(2025, 10, 29);
            LocalDate b2 = LocalDate.of(2025, 12, 1);
            Event eventGetted15 = this.registerEvent(
                "Feria de las Alasitas",
                "Una celebración en la que se venden miniaturas de objetos deseados como casas, autos o dinero, que se ofrecen al Ekeko (dios de la abundancia).", 
                " Se origina en las culturas prehispánicas andinas, donde se pedía prosperidad a los dioses con ofrendas simbólicas."
                                        , 
                                        -17.39841050244694, -66.17584347274092,
                                         true,
                                         a2, 
                                         b2, 
                                         1);
                this.registerImage("eb7xtge90g6w6opeljp6", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734449503/eb7xtge90g6w6opeljp6.jpg", 
            "eb7xtge90g6w6opeljp6", 
            eventGetted15);
            this.registerImage("tuotqwuhnsdkdce34oyo", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734449515/tuotqwuhnsdkdce34oyo.jpg", 
            "tuotqwuhnsdkdce34oyo", 
            eventGetted15);
            this.registerImage("l6d9ej3bj8nkvn8bjxxx", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734449524/l6d9ej3bj8nkvn8bjxxx.jpg", 
            "l6d9ej3bj8nkvn8bjxxx", 
            eventGetted15);

            Event eventGetted16 = this.registerEvent(
                "Proyecto mARTadero",
                "Es uno de los centros culturales más activos de Cochabamba, ubicado en un antiguo matadero convertido en un espacio de arte contemporáneo. Aquí se organizan exposiciones de pintura, escultura, fotografía y arte digital.", 
                " Fundado en 2005, se ha convertido en un referente cultural donde confluyen artistas emergentes y consolidados."
                                        , 
                                        -17.39841050244694, -66.17584347274092,
                                         true,
                                         a, 
                                         b, 
                                         5);
                this.registerImage("jnzeh5evh3gvfr5w3b4f", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734449929/jnzeh5evh3gvfr5w3b4f.jpg", 
            "jnzeh5evh3gvfr5w3b4f", 
            eventGetted16);
            this.registerImage("h6c7wemh6jkvxwodqwpu", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734449936/h6c7wemh6jkvxwodqwpu.jpg", 
            "h6c7wemh6jkvxwodqwpu", 
            eventGetted16);

            Event eventGetted17 = this.registerEvent(
                "Casona Santiváñez",
                "Es uno de los centros culturales más activos de Cochabamba, ubicado en un antiguo matadero convertido en un espacio de arte contemporáneo. Aquí se organizan exposiciones de pintura, escultura, fotografía y arte digital.", 
                " La casona data del siglo XVIII y es un espacio patrimonial restaurado para actividades culturales."
                                        , 
                                        -17.394446419622916, -66.15912990502875,
                                         true,
                                         a, 
                                         b, 
                                         5);
                this.registerImage("w91fgptvammlwrqpm5lm", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450160/w91fgptvammlwrqpm5lm.jpg", 
            "w91fgptvammlwrqpm5lm", 
            eventGetted17);
            this.registerImage("w91fgptvammlwrqpm5lm", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450160/w91fgptvammlwrqpm5lm.jpg", 
            "w91fgptvammlwrqpm5lm", 
            eventGetted17);
            Event eventGetted18 = this.registerEvent(
                "Alianza Francesa de Cochabamba",
                "Realiza exposiciones de arte que promueven el intercambio cultural entre Bolivia y Francia. Aquí se pueden apreciar obras de artistas locales e internacionales.", 
                "La Alianza Francesa, con una larga trayectoria en Cochabamba, ha sido un punto clave para la difusión del arte y la cultura."
                                        , 
                                        -17.382885744648238, -66.15351580502919,
                                         true,
                                         a, 
                                         b, 
                                         5);
                this.registerImage("fajqub8fj6snymc2mpko", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450167/fajqub8fj6snymc2mpko.jpg", 
            "fajqub8fj6snymc2mpko", 
            eventGetted18);
            Event eventGetted19 = this.registerEvent(
                "Casa de la Cultura Cochabamba",
                "Es un espacio gubernamental que promueve el arte local, organizando exposiciones de pintura, escultura y fotografía, tanto de artistas consagrados como emergentes.", 
                "Ha sido un punto de encuentro cultural en la ciudad desde hace varias décadas."
                                        , 
                                        -17.3918467945358, -66.15576893427887,
                                         true,
                                         a, 
                                         b, 
                                         5);
                this.registerImage("nal0q6xsgmsjlqglskrg", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450441/nal0q6xsgmsjlqglskrg.jpg", 
            "nal0q6xsgmsjlqglskrg", 
            eventGetted19);
            this.registerImage("g0u9piv0plzigtwtjaky", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450445/g0u9piv0plzigtwtjaky.jpg", 
            "g0u9piv0plzigtwtjaky", 
            eventGetted19);
            this.registerImage("kvtsjhnmpfv0vay9pxql", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450450/kvtsjhnmpfv0vay9pxql.jpg", 
            "kvtsjhnmpfv0vay9pxql", 
            eventGetted19);
            Event eventGetted20 = this.registerEvent(
                "Galería del Centro Cultural Fearless",
                "Un espacio reciente que promueve el arte contemporáneo en todas sus formas, organizando muestras colectivas e individuales de artistas jóvenes.", 
                ""
                                        , 
                                        -17.368781611106193, -66.16303113039336,
                                         true,
                                         a, 
                                         b, 
                                         5);
                this.registerImage("yuelyb6arfhb3lavozuj", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450627/yuelyb6arfhb3lavozuj.jpg", 
            "yuelyb6arfhb3lavozuj", 
            eventGetted20);
            this.registerImage("grsrjnruyktzfyygofia", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450668/grsrjnruyktzfyygofia.jpg", 
            "grsrjnruyktzfyygofia", 
            eventGetted20);
            this.registerImage("ex7tpt1fwrb1dawm8kqs", 
            "https://res.cloudinary.com/dgr3g2a0g/image/upload/v1734450671/ex7tpt1fwrb1dawm8kqs.jpg", 
            "ex7tpt1fwrb1dawm8kqs", 
            eventGetted20);
        }
    }

    private Event registerEvent(String nombreEvento, String descripcionEvento, String historiaEvento, double latitud, double longitud, boolean permanente, LocalDate a, LocalDate b, long idCategoria){
        Event event = new Event();
        event.setNombreEvento(nombreEvento);  
        event.setDescripcionEvento(descripcionEvento);  
        event.setLongitud(longitud);
        event.setLatitud(latitud);  
        event.setHistoriaEvento(historiaEvento); 
        event.setPermanente(permanente); 
        try{
            event.setFechaInicioEvento(Date.from(a.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            event.setFechaFinEvento(Date.from(b.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        } catch (Exception e){}
        Category category = this.categoryRepository.findById(idCategoria).get();
        event.setCategory(category);
        return this.eventRepository.save(event);
    }

    private void registerImage(String nombreImagen,String urlImagen,String idImage,Event event){
            Image image1 = new Image(nombreImagen, urlImagen, idImage, event);
            this.imageRepository.save(image1);
    }
}
