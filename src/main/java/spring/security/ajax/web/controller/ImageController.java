package spring.security.ajax.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImageController {

    public enum Items {

        itemGuitar, itemShades, itemCowbell, itemHat
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getDetails.do")
    public ResponseEntity<String> helloworld(@RequestParam(value = "ImageID", required = true) String itemName) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Items selectedItem = Items.valueOf(itemName);
        String details = "<p>n/a</p>";

        switch (selectedItem) {
            case itemGuitar:
                details = "<p>Pete Townshend once played this guitar while his own axe was in the shop having bits of drumkit removed from it.</p>";
                break;
            case itemShades:
                details = "<p>Yoko Ono's sunglasses. While perhaps not valued much by Beatles fans, this pair is rumored to have been licked by John Lennon.</p>";
            case itemCowbell:
                details = "<p>Remember the famous \"more cowbell\" skit from Saturday Night Live? Well, this is the actual cowbell.</p>";
                break;
            case itemHat:
                details = "<p>Michael Jackson's hat, as worn in the \"Billie Jean\" video. Not really rock memorabilia, but it smells better than Slash's tophat.</p>";
                break;

        }
        return new ResponseEntity<String>(details, headers, HttpStatus.OK);

    }
}