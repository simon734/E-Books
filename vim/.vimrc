set nocompatible              " be iMproved, required
filetype off

set rtp+=~/vimfiles/bundle/Vundle.vim
call vundle#begin()

Plugin 'VundleVim/Vundle.vim'

"Add your bundles here
Plugin 'vim-scripts/c.vim'
Plugin 'Valloric/YouCompleteMe'
Plugin 'scrooloose/nerdtree'
Plugin 'Syntastic' "uber awesome syntax and errors highlighter
Plugin 'altercation/vim-colors-solarized' "T-H-E colorscheme
Plugin 'https://github.com/tpope/vim-fugitive' "So awesome, it should be illegal 
call vundle#end() 

"must be last
"
filetype plugin indent on " load filetype plugins/indent settings
colorscheme desert 
syntax on                      " enable syntax

set exrc
set secure

set tabstop=4
set softtabstop=4
set shiftwidth=4
set expandtab

set colorcolumn=100
highlight ColorColumn ctermbg=darkgray

"let &path.="G:/Projects/work/trunk-client-0711/codes/../dependences/boost_1_49_0,"

    
 
" Setting up Vundle - the vim plugin bundler end
