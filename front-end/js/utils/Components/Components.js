import Html from "../html";
import Api from "..Api/Api"

export default () => new Components()

class Components {
    getAppContext() {
        return Html().select("#app");
    }
    getWrapperDiv() {
        return Html()
            .create("div")
            .addClass("wrapper");
    }
    renderHeaderBlock(requestData) {
        const headerBlock = Html().create('header').addClass('main-header');
        const titleBlock = Html().create('h1').addClass('main-header__title').text("Album")
        headerBlock.addChild(titleBlock);
        return headerBlock
    }
    renderNavBlock() {
        const navBlock = Html().create('nav').addClass('nav');
        const navList = Html().create('ul').addClass('nav_list');

        const navListItemOne = Html().create('li')
            .addClass('nav__list-item')
            .addChild(
                Html().create('a')
                    .addAttribute('href', '#')
                    .text("Home")
                    .click((event) => {
                        event.preventDefault()
                        this.renderPageHome()

                    }
                    )
            )
        const navListItemTwo = Html().create('li')
            .addClass('nav__list-item')
            .addChild(
                Html().create('a')
                    .addAttribute('href', 'allArtistTemplate.html')
                    .text("Artist")
                    .click((event) => {
                        event.preventDefault()
                        this.renderPageArtist()

                    }
                    )
            )
        const navListItemThree = Html().create('li')
            .addClass('nav__list-item')
            .addChild(
                Html().create('a')
                    .addAttribute('href', 'allAlbumsTemplate.html')
                    .text("Albums")
                    .click((event) => {
                        event.preventDefault()
                        this.renderPageArtist()

                    }
                    )
            )
        const navListItemFour = Html().create('li')
            .addClass('nav__list-item')
            .addChild(
                Html().create('a')
                    .addAttribute('href', 'allSongsTemplate.html')
                    .text("Songs")
                    .click((event) => {
                        event.preventDefault()
                        this.renderPageSong()

                    }
                    )
            )
        navList.addChild(navListItemOne)
        navList.addChild(navListItemTwo)
        navList.addChild(navListItemThree)
        navList.addChild(navListItemFour)
        navBlock.addChild(navList)
        return navBlock;
    }


}