#include <iostream>
using namespace std;

struct node {
	char left;
	char right;
};

struct node tree[27];

void preorder(char x) {
	if (x == '.') return;
	cout << x;
	preorder(tree[x].left);
	preorder(tree[x].right);
}

void inorder(char x) {
	if (x == '.') return;
	inorder(tree[x].left);
	cout << x;
	inorder(tree[x].right);
}

void postorder(char x) {
	if (x == '.') return;
	postorder(tree[x].left);
	postorder(tree[x].right);
	cout << x;
}


int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		char a, b, c;
		cin >> a >> b >> c;

		tree[a].left = b;
		tree[a].right = c;
	}
	
	preorder('A');
	cout << '\n';
	inorder('A');
	cout << '\n';
	postorder('A');
	cout << '\n';

}