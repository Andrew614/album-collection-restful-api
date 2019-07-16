const slides = document.querySelectorAll(".heroImg")

let slideIndex = 0

const render = () => {
    
    for (let slide of slides){
        slide.classList.add("hidden")
    }
    // access a item in the slides collection by the index via slidesIndex
    slides[slideIndex].classList.remove("hidden")
} 
    // call the render function
    render()

const nextSlide = () => {
    slideIndex ++
    
    if (slideIndex=== slides.length){
        slideIndex=0
    }
    render()

}
// call a global function
setInterval(nextSlide,2000)