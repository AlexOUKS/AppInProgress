import React, { Component } from 'react';
import Header from './comp/Header';
import Footer from './comp/Footer';
import Body from './comp/Body';



import './Main.css';

class Main extends Component {
    constructor(props) {
        super(props);
        this.state = {
          page: 'home',
          crumbs : ["home", "sessions"]
        };
    }

    handleChildClick(header) {
        switch (header) {
            case "sessions":
                this.setState({page : "sessions"});
                break;
            case "home":
                this.setState({page : "home"});
                break;
            default:
                this.setState({page : "home"});
                break;
        }
        

     }

    render() {
        return (
            
                <React.Fragment>
                    <Header callbackFromParent={this.handleChildClick.bind(this)} crumbs={this.state.crumbs}/>
                    <div id="mainBlock">
                        <Body page={this.state.page} />
                    </div> 
                    <div id="footer">
                        <Footer />
                    </div> 
                </React.Fragment>   
        );
    }
}


export default Main; 