git remote set-url origin https://github.com/jensWorkGit/testlazy.git

git remote add origin https://github.com/jensWorkGit/testlazyloading.git
git push -u origin master

# in order to get it working 
* hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
* and in the application.yml open-in-view must be set to true
