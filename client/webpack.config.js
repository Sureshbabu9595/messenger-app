const path = require("path");
const MiniCssExtractionPlugin = require("mini-css-extract-plugin");
const {getIfUtils, propIf, removeEmpty} = require("webpack-config-utils");
const CleanWebpackPlugin = require("clean-webpack-plugin");
const HardSourceWebpackPlugin = require("hard-source-webpack-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");

const pkg = require("./package.json");
const config = pkg.config;

const DIST = path.resolve(__dirname,'dist');
const SRC = path.resolve(__dirname,'src');

const REGEX_BABEL_LOADER = /\.(js|jsx)$/;
const REGEX_STYLE_LOADER = /\.css$/;
const REGEX_FILE_LOADER = /\.(png|jpg|jpeg|gif|svg|ico|ttf|woff|woff2)$/;

module.exports = function(env){
	const wpConfig = {
		entry:{
			app: path.join(SRC,"index.js"),
			externals: [
				"react",
				"react-dom",
				"react-router-dom",
				"redux",
				"redux-thunk",
				"react-redux"
			]
		},
		output: {
			crossOriginLoading: "anonymous",
			filename: "[name].bundle.js",
			path: DIST,
			publicPath: `/${config.context}/`,
			chunkFilename: "[name].chunk.js"
		},
		devtool: "inline-source-map",
		devServer: {
			disableHostCheck: true,
			contentBase: path.join(DIST),
			publicPath: `/${config.context}/`,
			openPage: `/${config.context}/`,
			historyApiFallback:{
				index: `/${config.context}/`,
			},
			index: "index.html"
		},
		resolve: {
			extensions: [".js",".jsx",".css"]
		},
		optimization:{
			splitChunks: {
				automaticNameDelimiter: "_"
			}
		},
		module: {
			rules:[
				{
					test: REGEX_FILE_LOADER,
					exclude: /node_modules/,
					use: ["file-loader"]
				},
				{
					test: REGEX_STYLE_LOADER,
					use: [MiniCssExtractionPlugin.loader, "css-loader"]
				},
				{
					test: REGEX_BABEL_LOADER,
					loader: "babel-loader",
					options: { presets: ['@babel/env','@babel/preset-react'] },
					include: [
						path.join(__dirname, "redux.devtools.js"),
						path.join(__dirname, "src"),
						path.join(__dirname, "node_modules/react-intl"),
						path.join(__dirname, "node_modules/intl-messageformat"),
						path.join(__dirname, "node_modules/intl-messageformat-parser")
					]
				}
			]
		},
		plugins: removeEmpty([
			new HtmlWebpackPlugin({
				filename: path.join(__dirname,"../server/src/main/webapp/WEB-INF/views/index.html"),
				chunks: ["app","externals"],
				favicon:"./src/assets/images/favicon.ico"
			}),
			new MiniCssExtractionPlugin({
				filename: "[name].bundle.css"
			})
		])
	};
	return wpConfig;	
};