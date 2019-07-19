import Html from './html.js'

describe("Html", () => {

    describe("create", () => {

        describe("should return new html object", () => {


            test("should be an object", () => {

                expect(typeof Html().create('h1')).toBe('object');

            })

            test('Throws an error if no element is passed', () => {
                expect(() => {
                    Html().create()
                }).toThrow('Must pass a HTML element')

            })

            test('Throws an error if an invalid element is passed', () => {
                expect(() => {
                    Html().create('asdfasd')
                }).toThrow('Invalid html element')
            })
        })
    })
})