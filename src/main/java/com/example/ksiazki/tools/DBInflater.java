package com.example.ksiazki.tools;

import com.example.ksiazki.model.Announce;
import com.example.ksiazki.model.Book;
import com.example.ksiazki.model.Writer;
import com.example.ksiazki.model.Publisher;
import com.example.ksiazki.repositories.AnnounceRepository;
import com.example.ksiazki.repositories.WriterRepository;
import com.example.ksiazki.repositories.PublisherRepository;
import com.example.ksiazki.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(BookRepository bookRepository, WriterRepository writerRepository, PublisherRepository publisherRepository, AnnounceRepository announceRepository) {
        this.bookRepository = bookRepository;
        this.writerRepository = writerRepository;
        this.publisherRepository = publisherRepository;
        this.announceRepository = announceRepository;
    }
    private AnnounceRepository announceRepository;
    private BookRepository bookRepository;
    private WriterRepository writerRepository;
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Announce bb=new Announce("Romeo and Julied","Shakespare","1564");

        Writer johnny = new Writer("William", "Shakespare", "1564");
        Publisher columbia = new Publisher("T. Glucksberga", "987-987-564", "England");
        Book aBoyNamedSue = new Book("Romeo and Julied", "Drama", "1983129873",
                "1597", columbia);

        johnny.getBooks().add(aBoyNamedSue);
        aBoyNamedSue.getWriters().add(johnny);
        announceRepository.save(bb);
        publisherRepository.save(columbia);
        writerRepository.save(johnny);
        bookRepository.save(aBoyNamedSue);

        Announce aa=new Announce("The Old Man and the Sea","Hemingway","1899");
        Writer bob = new Writer("Ernest", "Hemingway", "1899");
        Publisher island = new Publisher("Charles Scribner's Sons", "234-567-890", "New York");
        Book threeLittleBirds = new Book("The Old Man and the Sea", "Story", "98172391123",
                "1952", island);
        bob.getBooks().add(threeLittleBirds);
        threeLittleBirds.getWriters().add(bob);
        announceRepository.save(aa);
        publisherRepository.save(island);
        writerRepository.save(bob);
        bookRepository.save(threeLittleBirds);


        Announce cc=new Announce("Crime and Punishment","Dostoevsky","1821");
        Writer freddie = new Writer("Fyodor", "Dostoevsky", "1821");
        Publisher emi = new Publisher("The Russian Messenger","123-123-123","Moscow");
        Book callingAllGirls = new Book("Crime and Punishment", "Novel", "09309823091",
                "1867", emi);
        freddie.getBooks().add(callingAllGirls);
        callingAllGirls.getWriters().add(freddie);
        announceRepository.save(cc);
        publisherRepository.save(emi);
        writerRepository.save(freddie);
        bookRepository.save(callingAllGirls);

    }
}

