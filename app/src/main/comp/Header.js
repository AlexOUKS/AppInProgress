import React, { Component } from 'react';
import './Header.css';

class Header extends Component {

    constructor(props) {
        super(props);
        this.state = {
          crumbs : props.crumbs,
          display : []
        };
        
    }
    componentDidMount() {
        this.crumbs();
    }



    display(event) {
        this.props.callbackFromParent(event.target.textContent);
    }
    crumbs() {
        console.log(this.props.crumbs);
        let htmlBuffer = [];
        
        this.state.crumbs.forEach(element => {
            console.log(element);
            htmlBuffer.push(<li onClick={this.display.bind(this)} className="crumb">{element}</li>);
        });

        this.setState({display : htmlBuffer});       
    }

    render() {
        return (
            <header>
                <h1>Vinksel Corp.</h1>
                <nav id="navigationMenu">
                    
                </nav>  
                <nav id="breadCrumb">
                    <ol>
                        {this.state.display}
                    </ol>
                </nav>
            </header>
        );
    }
}



export default Header; 