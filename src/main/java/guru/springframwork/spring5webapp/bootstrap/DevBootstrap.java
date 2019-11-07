package guru.springframwork.spring5webapp.bootstrap;

import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.model.Book;
import guru.springframwork.spring5webapp.model.Publisher;
import guru.springframwork.spring5webapp.repositories.AuthorRepository;
import guru.springframwork.spring5webapp.repositories.BookRepository;
import guru.springframwork.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
      initData();
    }

    public void initData(){
        Publisher publisher=new Publisher();
        publisher.setName("Sof");
        publisherRepository.save(publisher);
        Author eric =new Author("Eric","evans");
        Book book1=new Book("Domain driven design" ,"1234",publisher);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);


        Author ROD =new Author("ROD","JONDON");
        Book book2 =new Book("J2EE " ,"1234",publisher);
        ROD.getBooks().add(book2);
        authorRepository.save(ROD);
        bookRepository.save(book2);

    }
}
