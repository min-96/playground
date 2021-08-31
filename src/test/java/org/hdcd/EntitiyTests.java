package org.hdcd;

import org.apache.catalina.User;
import org.hdcd.domain.Item;
import org.hdcd.domain.Member;
import org.hdcd.domain.UserItem;
import org.hdcd.domain.UserItemId;
import org.hdcd.repository.ItemRepository;
import org.hdcd.repository.MemberRepository;
import org.hdcd.repository.UserItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Commit
@SpringBootTest
public class EntitiyTests {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    UserItemRepository userItemRepository;

    //등록테스트
    @Transactional
    @Test
    public void testRegisterWithUserItemAtTransactional(){
        Item item = new Item();
        item.setItemName("macBook");
        item.setPrice(2000000);

        itemRepository.save(item);

        Item item1 = new Item();
        item1.setItemName("Imac");
        item1.setPrice(400000);

        itemRepository.save(item);

        Member member = new Member();
        member.setUserId("minn");
        member.setPassword("1234");
        member.setUserName("minyouh");

        UserItem userItem = new UserItem();
        userItem.setMember(member);
        userItem.setItem(item);
        userItem.setAmount(5);

        UserItem userItem1 = new UserItem();
        userItem1.setMember(member);
        userItem1.setItem(item1);
        userItem1.setAmount(2);

        member.addUserItem(userItem);
        member.addUserItem(userItem1);


        memberRepository.save(member);
    }

    //목록조회테스트
    @Transactional
    @Test
    public void testList(){
        Iterable<Member> members = memberRepository.findAll();

        for(Member m : members){
            System.out.println(m);
            List<UserItem> userItems = m.getUserItems();
            for(UserItem userItem : userItems){
                System.out.println(userItem);

            }
        }
    }

    @Transactional
    @Test
    public void testModify(){
        Optional<Member> memberOptional = memberRepository.findById(1L);

        if(memberOptional.isPresent()){
            Member member=memberOptional.get();
            List<UserItem> userItems = member.getUserItems();
            UserItem firstUserItem = userItems.get(0);

            System.out.println(firstUserItem);
            firstUserItem.setAmount(100);

            memberRepository.save(member);

        }
    }

    //삭제테스트
    @Transactional
    @Test
    public void testRemove(){
        Optional<Member> memberOptional = memberRepository.findById(1L);

        if(memberOptional.isPresent()){
           Member member= memberOptional.get();
           List<UserItem> userItems = member.getUserItems();
           userItems.remove(0);

           memberRepository.save(member);
        }
     }
     @Transactional
    @Test
    public void testRemoveUserItemAtTranscational2(){
        Optional<Member> memberOptional = memberRepository.findById(1L);

        Member member=null;
        if(memberOptional.isPresent()){
             member = memberOptional.get();
        }

        Optional<Item> itemOptional = itemRepository.findById(1L);

        Item item=null;
        if(itemOptional.isPresent()){
            item= itemOptional.get();
        }

        UserItemId userItemId = new UserItemId();
       userItemId.setMember(member.getUserNo());
        userItemId.setItem(item.getItemNo());

        userItemRepository.deleteById(userItemId);


    }
}
