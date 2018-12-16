import React, { Component } from 'react';
import Header from './comp/Header';
import Footer from './comp/Footer';
import Body from './comp/Body';

class Main extends Component {
    constructor(props) {
        super(props);
        this.state = {
          page: 'home',
          crumbs : ["test", "test2"]
        };
    }
    render() {
        return (
            <React.Fragment>
                <Header crumbs={this.state.crumbs}/>
                <Body page={this.state.page} />
                <Footer />
            </React.Fragment>   
        );
    }
}


export default Main; 