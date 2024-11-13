import PropTypes from 'prop-types';

const Container = ({ children, ...props }) => {
    return (
        <>
        <div {...props}> 
            {children}
        </div>
        </>
    );
};

Container.propTypes = {
    children: PropTypes.node.isRequired,
};

export default Container;